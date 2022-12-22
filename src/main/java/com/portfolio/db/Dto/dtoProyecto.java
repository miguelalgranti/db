
package com.portfolio.db.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String nombreP;
    @NotBlank
    private String fechaP;
    @NotBlank
    private String imagenP;

    public dtoProyecto() {
    }

    public dtoProyecto(String descripcionP, String nombreP, String fechaP, String imagenP) {
        this.descripcionP = descripcionP;
        this.nombreP = nombreP;
        this.fechaP = fechaP;
        this.imagenP = imagenP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setnN(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }
    
    
}
