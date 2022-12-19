
package com.portfolio.db.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String institucionE;
    @NotBlank
    private String periodoE;
    @NotBlank
    private String imagenE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String descripcionE, String institucionE, String periodoE, String imagenE) {
        this.descripcionE = descripcionE;
        this.institucionE = institucionE;
        this.periodoE = periodoE;
        this.imagenE = imagenE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getInstitucionE() {
        return institucionE;
    }

    public void setInstitucionE(String institucionE) {
        this.institucionE = institucionE;
    }

    public String getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(String periodoE) {
        this.periodoE = periodoE;
    }

    public String getImagenE() {
        return imagenE;
    }

    public void setImagenE(String imagenE) {
        this.imagenE = imagenE;
    }
    
    
}
