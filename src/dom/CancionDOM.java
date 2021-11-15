/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.util.ArrayList;
import java.util.List;
import modelo.Cancion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Cristhian Armando
 */
public class CancionDOM {
    
    public List<Cancion> open(String source){
        List<Cancion> canciones= new ArrayList();
        Cancion cancion;
        try{
            Document d= DOMHelper.getDocument(source);
            NodeList nodos= d.getElementsByTagName("cancion");
            //recorrer la lista de canciones
           String titulo;
           String interprete;
           String genero;
           String album;
           int year;
           String ruta;
           for(int i=0;i<nodos.getLength();i++){
               Element item= (Element)nodos.item(i);
               titulo=item.getElementsByTagName("titulo").item(0).getTextContent();
               interprete=item.getElementsByTagName("interprete").item(0).getTextContent();
               genero=item.getElementsByTagName("genero").item(0).getTextContent();
               album=item.getElementsByTagName("album").item(0).getTextContent();
               year= Integer.parseInt( item.getElementsByTagName("año").item(0).getTextContent());
               ruta=item.getElementsByTagName("ruta").item(0).getTextContent();
               
               cancion=new Cancion(titulo,interprete,genero,album,year,ruta);
               canciones.add(cancion);
           }
           
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return canciones;
    }
    
    public void save(List<Cancion> lista,String target){
        String source;
        source=getClass().getResource("/recursos/FormatoCanciones.xml").toString();
        
        Cancion cancion;
        try{
            Document d= DOMHelper.getDocument(source);
            Element canciones= d.getDocumentElement();
            //Recorrer la lista para extraer las canciones y agregarlas al XML
            
           String titulo;
           String interprete;
           String genero;
           String album;
           int year;
           String ruta;
           
           for (int i=0;i<lista.size();i++){
               cancion= lista.get(i);
               titulo= cancion.getTitulo();
               interprete=cancion.getInterprete();
               genero=cancion.getGenero();
               album=cancion.getAlbum();
               year= cancion.getYear();
               ruta= cancion.getRuta();
               
               //crear tag cancion}
               Element item= d.createElement("cancion");
               //crear tag titulo
               Element tit= d.createElement("titulo");
               tit.appendChild(d.createTextNode(titulo));
               item.appendChild(tit);
               //crear interprere
               Element inte= d.createElement("interprete");
               inte.appendChild(d.createTextNode(interprete));
               item.appendChild(inte);
               //crear genero
               Element gen= d.createElement("genero");
               gen.appendChild(d.createTextNode(genero));
               item.appendChild(gen);               
               //crear album
               Element alb= d.createElement("album");
               alb.appendChild(d.createTextNode(album));
               item.appendChild(alb);               
               //crear year
               Element yea= d.createElement("año");
               yea.appendChild(d.createTextNode(""+year));
               item.appendChild(yea);              
               //crear ruta
               Element rut= d.createElement("ruta");
               rut.appendChild(d.createTextNode(ruta));
               item.appendChild(rut);

               canciones.appendChild(item);
           }
        //guardar
        DOMHelper.saveXML(d,target);
            
        }catch(Exception e){
        System.err.println(e.getMessage());
        }
    }
    }

