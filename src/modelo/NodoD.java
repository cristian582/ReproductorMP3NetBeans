/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cristhian
 * date 29/10/2021
 */
public class NodoD {
    private Cancion datos;
    private NodoD ant;
    private NodoD sig;

    public NodoD() {
    }

    public NodoD(Cancion datos) {
        this.datos = datos;
    }

    
    public Cancion getDatos() {
        return datos;
    }

    public void setDatos(Cancion datos) {
        this.datos = datos;
    }

    public NodoD getAnt() {
        return ant;
    }

    public void setAnt(NodoD ant) {
        this.ant = ant;
    }


 

    public NodoD getSig() {
        return sig;
    }

    public void setSig(NodoD sig) {
        this.sig = sig;
    }
    
    
    
    
}
