
package com.portfolio.db.Controller;

import com.portfolio.db.Dto.dtoProyecto;
import com.portfolio.db.Entity.Proyecto;
import com.portfolio.db.Security.Controller.Mensaje;
import com.portfolio.db.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "*")
public class CProyecto {
   @Autowired
   SProyecto sProyecto;
   @GetMapping("/lista")
   public ResponseEntity<List<Proyecto>> list(){
       List<Proyecto> list = sProyecto.list();
       return new ResponseEntity(list, HttpStatus.OK);
   }
   
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro) {
       if(StringUtils.isBlank(dtopro.getNombreP()))
           return new ResponseEntity(new Mensaje("el nombre de la institucion es obligatoria"),HttpStatus.BAD_REQUEST);
       
       if(sProyecto.existsByNombreP(dtopro.getNombreP()))
           return new ResponseEntity(new Mensaje("Es item ya existe"), HttpStatus.BAD_REQUEST);
       
      Proyecto proyecto = new Proyecto(dtopro.getNombreP(), dtopro.getDescripcionP(), dtopro.getFechaP(), dtopro.getImagenP());
        sProyecto.save(proyecto);
       return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro) {
       if(!sProyecto.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
       
       if(sProyecto.existsByNombreP(dtopro.getNombreP()) && sProyecto.getByNombreP(dtopro.getNombreP()).get().getId() !=id)
           return new ResponseEntity(new Mensaje("Es item ya existe"), HttpStatus.BAD_REQUEST);
       
       if(StringUtils.isBlank(dtopro.getNombreP()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       Proyecto proyecto = sProyecto.getOne(id).get();
       proyecto.setNombreP(dtopro.getNombreP());
       proyecto.setDescripcionP(dtopro.getDescripcionP());
       proyecto.setFechaP(dtopro.getFechaP());
       proyecto.setImagenP(dtopro.getImagenP());
       
       sProyecto.save(proyecto);
       return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
       
   }
  @DeleteMapping("/delete/{id}") 
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
      if(!sProyecto.existsById(id))
       return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
       
      sProyecto.delete(id);
       
       return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
   }
}