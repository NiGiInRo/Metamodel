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
public class Viewcomponent {
    
     private int idcomponent;
     private String namecomponent;
     Lista idlist = new Lista();
     Columna idcolumna = new Columna();
     Detalle iddetalle = new Detalle();
    Viewelement idelement = new Viewelement();

    public int getIdcomponent() {
        return idcomponent;
    }

    public void setIdcomponent(int idcomponent) {
        this.idcomponent = idcomponent;
    }

    public String getNamecomponent() {
        return namecomponent;
    }

    public void setNamecomponent(String namecomponent) {
        this.namecomponent = namecomponent;
    }

    public Lista getIdlist() {
        return idlist;
    }

    public void setIdlist(Lista idlist) {
        this.idlist = idlist;
    }

    public Columna getIdcolumna() {
        return idcolumna;
    }

    public void setIdcolumna(Columna idcolumna) {
        this.idcolumna = idcolumna;
    }

    public Detalle getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Detalle iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Viewelement getIdelement() {
        return idelement;
    }

    public void setIdelement(Viewelement idelement) {
        this.idelement = idelement;
    }
    
    
}
