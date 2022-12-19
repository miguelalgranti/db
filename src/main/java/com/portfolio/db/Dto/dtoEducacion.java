
package com.portfolio.db.Dto;

import javax.validation.constraints.NotBlank;




public class dtoEducacion {
    @NotBlank
    private String institucionEd;
    @NotBlank
    private String descripcionEd;
        @NotBlank
    private String periodoEd;
            @NotBlank
    private String imagenEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String descripcionEd, String institucionEd, String periodoEd, String imagenEd) {
        this.institucionEd = institucionEd;
        this.descripcionEd = descripcionEd;
        this.periodoEd = periodoEd;
        this.imagenEd = imagenEd;
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
