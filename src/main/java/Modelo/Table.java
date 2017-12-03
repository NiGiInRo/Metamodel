/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Labin
 */
public class Table {
    
    private int idTabla;
    private String name;
    private int idEsquema;

    public Table() {
    }

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEsquema() {
        return idEsquema;
    }

    public void setIdEsquema(int idEsquema) {
        this.idEsquema = idEsquema;
    }

    

    @Override
    public String toString() {
        return "Table{" + "idTabla=" + idTabla + ", name=" + name + ", idEsquema=" + idEsquema + '}';
    }
    
    
}
