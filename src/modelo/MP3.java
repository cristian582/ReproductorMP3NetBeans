/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import javazoom.jl.player.Player;

/**
 *
 * @author USUARIO
 */
public class MP3 implements Serializable{
    private String filename;
    private Player player;
//    static MP3 instance= null;
    
    public MP3(String filename){
        this.filename= filename;
    }

    public synchronized void play(){
        try{
            FileInputStream fis= new FileInputStream(filename); 
            BufferedInputStream bis = new BufferedInputStream(fis);
            player= new Player(bis);
        }catch(Exception e){
            System.err.println("Error al intentar cargar archivo: "+filename);
            System.err.println(e.getMessage());
        }
        new Thread(){
            public void run(){
                try{
                   player.play();
                }catch(Exception e){
                    System.err.println("Error al intentar reproducir");
                }
            }
        }.start();
    }
    
    public void close(){
        if(player != null){
            player.close();
        }
    }
}
