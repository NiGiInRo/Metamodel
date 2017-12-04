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
public class Pgb {
    
    private int idpgb;
    Interactionflow idinteraction = new Interactionflow();

    public int getIdpgb() {
        return idpgb;
    }

    public void setIdpgb(int idpgb) {
        this.idpgb = idpgb;
    }

    public Interactionflow getIdinteraction() {
        return idinteraction;
    }

    public void setIdinteraction(Interactionflow idinteraction) {
        this.idinteraction = idinteraction;
    }
    
    
    
    
}
