/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cristhian   
 * 
 * date 29/10/2021
 */
public class Cancion {
    private String titulo;
    private String interprete;
    private String album;
    private String genero;
    private int year;
    private String ruta;
    
    public Cancion(){
    }

    public Cancion(String titulo, String interprete, String album, String genero, int year, String ruta) {
        this.titulo = titulo;
        this.interprete = interprete;
        this.album = album;
        this.genero = genero;
        this.year = year;
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
