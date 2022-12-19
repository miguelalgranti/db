
package com.portfolio.db.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucionEd;
    private String descripcionEd;
    private String periodoEd;
    private String imagenEd;

    public Educacion() {
    }

    public Educacion(String institucionEd, String descripcionEd, String periodoEd, String imagenEd) {
        this.institucionEd = institucionEd;
        this.descripcionEd = descripcionEd;
        this.periodoEd = periodoEd;
        this.imagenEd = imagenEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucionEd() {
        return institucionEd;
    }

    public void setInstitucionEd(String institucionEd) {
        this.institucionEd = institucionEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
     public String getPeriodoEd() {
        return periodoEd;
    }

    public void setPeriodoEd(String periodoEd) {
        this.periodoEd = periodoEd;
    }
    public String getImagenEd() {
        return imagenEd;
    }

    public void setImagenEd(String imagenEd) {
        this.imagenEd = imagenEd;
    }
}



