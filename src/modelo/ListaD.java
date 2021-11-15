/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian date 29/10/2021
 */
public class ListaD {

    private NodoD inicio;
    private NodoD fin;
    private NodoD actual;

    public NodoD getActual() {
        return actual;
    }

    public void setActual(NodoD actual) {
        this.actual = actual;
    }

    public void insertar(NodoD nuevo) {
        NodoD aux;
        if (inicio == null) {//caso 1 lista vacia
            inicio = nuevo;
            fin = nuevo;

        } else {
            aux = inicio;
            while (aux != null && nuevo.getDatos().getTitulo().compareTo(aux.getDatos().getTitulo()) > 0) {
                aux = aux.getSig();
            }
            if (aux == null) {//caso 2 insertar al final de la lista
                fin.setSig(nuevo);
                nuevo.setAnt(fin);
                fin = nuevo;
            } else if (aux == inicio) {//caso 3
                inicio = nuevo;
                nuevo.setSig(aux);
                aux.setAnt(nuevo);
            } else {//caso 4 insertar entre dos nodos
                nuevo.setSig(aux);
                aux.getAnt().setSig(nuevo);
                aux.setAnt(nuevo);
                nuevo.setAnt(aux.getAnt());
            }
        }
        actual = nuevo;
    }

    public void irInicio() {
        actual = inicio;
    }

    public void irFin() {
        actual = fin;
    }

    public void irAnterior() {
        if (actual == inicio) {
            actual = fin;
        } else if (actual.getAnt() != null) {
            actual = actual.getAnt();
        }
    }

    public void irSiguiente() {
        if (actual == fin) {
            actual = inicio;
        } else if (actual.getSig() != null) {
            actual = actual.getSig();
        }
    }

    public boolean estaVacia() {
        return (inicio == null);
    }

    public List<Cancion> getList() {
        List<Cancion> lista = new ArrayList();
        NodoD aux = inicio;
        while (aux != null) {
            lista.add(aux.getDatos());
            aux = aux.getSig();
        }
        return lista;
    }
    //buscar

    public NodoD buscar(String titulo) {
        NodoD aux = inicio;
        Cancion cancion = new Cancion();
        boolean res = true;

        while (aux != null) {
            cancion = aux.getDatos();
            if (cancion.getTitulo().equals(titulo)) {
                //inicio.getDatos();
                actual = aux;
                res = false;
            }
            System.out.println("" + cancion.getTitulo());
            aux = aux.getSig();
        }
        if (res == true) {
            JOptionPane.showMessageDialog(null, "Cancion no encontrada.");
        }
        return actual;
    }

}
