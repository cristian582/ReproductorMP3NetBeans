/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *  Clase que permite abrir y guardar documentos XML
 * @author Usuario
 */
public class DOMHelper {
    public static Document getDocument(String ruta) {
        Document d=null;
        try{
            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            d= db.parse(ruta);
        }catch(Exception e){
            d= null;
        }
        return d;
    }
    
    public static String getXML(Document d){
        String resultado = "";
        try{
            TransformerFactory tff= TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource source = new DOMSource(d);
            tf.transform(source, sr);
            resultado = sw.toString();
        }catch(Exception e){
            resultado = "";
        }
        
        return resultado;
    }
    
    public static void saveXML(Document d, String ruta) {
        try
        {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf= tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource ds=new DOMSource(d);
            StreamResult sr= new StreamResult(ruta);
            tf.transform(ds, sr);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    }
}
