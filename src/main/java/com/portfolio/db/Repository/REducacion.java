
package com.portfolio.db.Repository;

import com.portfolio.db.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstitucionEd(String institucionEd);
    public boolean existsByInstitucionEd(String institucionEd);
}
