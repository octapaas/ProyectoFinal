/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myportfolio.boc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidades {
    @NotBlank
    private String nombreH;
    @NotBlank
    private String porcentajeH;
    @NotBlank
    private String imgH;

    //Contructores
    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombreH, String porcentajeH, String imgH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
        this.imgH = imgH;
    }

    // getters and setters
    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getPorcentajeH() {
        return porcentajeH;
    }

    public void setPorcentajeH(String porcentajeH) {
        this.porcentajeH = porcentajeH;
    }

    public String getImgH() {
        return imgH;
    }

    public void setImgH(String imgH) {
        this.imgH = imgH;
    }
}
