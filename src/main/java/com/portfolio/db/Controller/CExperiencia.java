
package com.portfolio.db.Controller;

import com.portfolio.db.Dto.dtoExperiencia;
import com.portfolio.db.Entity.Experiencia;
import com.portfolio.db.Security.Controller.Mensaje;
import com.portfolio.db.Service.SExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://portfolio-ap-ma.web.app", "https://miguelalgranti.online"})
public class CExperiencia {
   @Autowired
   SExperiencia sExperiencia;
   @GetMapping("/lista")
   public ResponseEntity<List<Experiencia>> list(){
       List<Experiencia> list = sExperiencia.list();
       return new ResponseEntity(list, HttpStatus.OK);
   }
   
   @PostMapping("/create")
   public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
       if(StringUtils.isBlank(dtoexp.getInstitucionE()))
           return new ResponseEntity(new Mensaje("el nombre de la institucion es obligatoria"),HttpStatus.BAD_REQUEST);
       
       if(sExperiencia.existsByInstitucionE(dtoexp.getInstitucionE()))
           return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
       
      Experiencia experiencia = new Experiencia(dtoexp.getInstitucionE(), dtoexp.getDescripcionE(), dtoexp.getPeriodoE(), dtoexp.getImagenE());
        sExperiencia.save(experiencia);
       return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
       if(!sExperiencia.existsById(id))
           return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
       
       if(sExperiencia.existsByInstitucionE(dtoexp.getInstitucionE()) && sExperiencia.getByInstitucionE(dtoexp.getInstitucionE()).get().getId() !=id)
           return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
       
       if(StringUtils.isBlank(dtoexp.getInstitucionE()))
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       
       Experiencia experiencia = sExperiencia.getOne(id).get();
       experiencia.setInstitucionE(dtoexp.getInstitucionE());
       experiencia.setDescripcionE(dtoexp.getDescripcionE());
       experiencia.setPeriodoE(dtoexp.getPeriodoE());
       experiencia.setImagenE(dtoexp.getImagenE());
       
       sExperiencia.save(experiencia);
       return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
       
   }
   @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
      if(!sExperiencia.existsById(id))
       return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
       
      sExperiencia.delete(id);
       
       return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
   }
}
