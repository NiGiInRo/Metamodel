
package Modelo;


public class Esquema {
    
    private String name;
    private int idEsquema ;

    public Esquema() {
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
        return "Esquema{" + "name=" + name + ", idEsquema=" + idEsquema + '}';
    }
    
    
    
    
}
