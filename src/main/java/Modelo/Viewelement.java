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
public class Viewelement {
    
    private int idelement;
    private String nameelement;
    Interactionflow idintetaction = new Interactionflow();

    public int getIdelement() {
        return idelement;
    }

    public void setIdelement(int idelement) {
        this.idelement = idelement;
    }

    public String getNameelement() {
        return nameelement;
    }

    public void setNameelement(String nameelement) {
        this.nameelement = nameelement;
    }

    public Interactionflow getIdinteraction() {
        return idintetaction;
    }

    public void setIdinteraction(Interactionflow idinteraction) {
        this.idintetaction = idinteraction;
    }
    
    
}
