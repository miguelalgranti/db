
package com.portfolio.db.Service;

import com.portfolio.db.Entity.Experiencia;
import com.portfolio.db.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByInstitucionE(String institucionE) {
        return rExperiencia.findByinstitucionE(institucionE);
    }
    
    public void save(Experiencia expe) {
        rExperiencia.save(expe);
    }
    
    public void delete(int id) {
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByInstitucionE(String institucionE) {
        return rExperiencia.existsByinstitucionE(institucionE);
    }
}

