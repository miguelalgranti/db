
package com.portfolio.db.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.portfolio.db.model.Persona;
import com.portfolio.db.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
 @Autowired
 private IPersonaService persoServ;
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
    persoServ.crearPersona(pers);
    }
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas () {
        return persoServ.verPersonas();    
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
      persoServ.borrarPersona(id);
    }
   
    }
    
 
    

