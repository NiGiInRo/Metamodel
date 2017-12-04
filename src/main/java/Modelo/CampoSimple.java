/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nicol
 */
public class CampoSimple {
    
    private int idsimple;
    private String edmask;
    private String defaultvalue;
    private String validationmessage;
    Campo idcampo = new Campo();

    public String getValidationmessage() {
        return validationmessage;
    }

    public void setValidationmessage(String validationmessage) {
        this.validationmessage = validationmessage;
    }
    
    

    public int getIdsimple() {
        return idsimple;
    }

    public void setIdsimple(int idsimple) {
        this.idsimple = idsimple;
    }

    public String getEdmask() {
        return edmask;
    }

    public void setEdmask(String edmask) {
        this.edmask = edmask;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public Campo getIdcampo() {
        return idcampo;
    }

    public void setIdcampo(Campo idcampo) {
        this.idcampo = idcampo;
    }
    
    
    
}
