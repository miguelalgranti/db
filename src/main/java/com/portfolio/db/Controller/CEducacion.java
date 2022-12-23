
package com.portfolio.db.Controller;

import com.portfolio.db.Dto.dtoEducacion;
import com.portfolio.db.Entity.Educacion;
import com.portfolio.db.Security.Controller.Mensaje;
import com.portfolio.db.Service.SEducacion;
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
@RequestMapping("/educ")
@CrossOrigin(origins = "*")
public class CEducacion {
   @Autowired
   SEducacion sEducacion;
   @GetMapping("/lista")
   public ResponseEntity<List<Educacion>> list(){
       List<Educacion> list = sEducacion.list();
       return new ResponseEntity(list, HttpStatus.OK);
   }
   
     @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
       if(StringUtils.isBlank(dtoedu.getInstitucionEd()))
           return new ResponseEntity(new Mensaje("el nombre de la institucion es obligatoria"),HttpStatus.BAD_REQUEST);
       
       if(sEducacion.existsByInstitucionEd(dtoedu.getInstitucionEd()))
           return new ResponseEntity(new Mensaje("Es item ya existe"), HttpStatus.BAD_REQUEST);
       
      Educacion educacion = new Educacion(dtoedu.getInstitucionEd(), dtoedu.getDescripcionEd(), dtoedu.getPeriodoEd(), dtoedu.getImagenEd());
        sEducacion.save(educacion);
       return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
       if(!sEducacion.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
       
       if(sEducacion.existsByInstitucionEd(dtoedu.getInstitucionEd()) && sEducacion.getByInstitucionEd(dtoedu.getInstitucionEd()).get().getId() !=id)
           return new ResponseEntity(new Mensaje("Es item ya existe"), HttpStatus.BAD_REQUEST);
       
       if(StringUtils.isBlank(dtoedu.getInstitucionEd()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       Educacion educacion = sEducacion.getOne(id).get();
       educacion.setInstitucionEd(dtoedu.getInstitucionEd());
       educacion.setDescripcionEd(dtoedu.getDescripcionEd());
       educacion.setPeriodoEd(dtoedu.getPeriodoEd());
       educacion.setImagenEd(dtoedu.getImagenEd());
       
       sEducacion.save(educacion);
       return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
       
   }
  @DeleteMapping("/delete/{id}") 
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
      if(!sEducacion.existsById(id))
       return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
       
      sEducacion.delete(id);
       
       return new ResponseEntity(new Mensaje("Item Eliminada"), HttpStatus.OK);
   }
}
