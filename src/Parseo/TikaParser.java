package Parseo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
/**
 * Clase para el extraer el texto de los documentos
 * @author fabricio
 */
public class TikaParser {
	/**
	 * Atributos
	 */
	Parser parseo = new AutoDetectParser();

	Metadata metadata = new Metadata();
	
	BodyContentHandler handler = new BodyContentHandler();
	
	InputStream texto = null;
   /**
    * Constructor que extrae el texto
    */
	public TikaParser(){
        

        try {
            texto = new BufferedInputStream(new FileInputStream(new File("b.txt")));
            
            parseo.parse(texto, handler, metadata, new ParseContext());
         
            for (String name : metadata.names()) {
                String value = metadata.get(name);

                //if (value != null) {
                 //  System.out.println("Metadata Name:  " + name);
                   // System.out.println("Metadata Value: " + value);
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (texto != null) {
                try {
                    texto.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
     
    }
	/**
	 * Método para retornar el texto
	 * @return handler
	 */
   public BodyContentHandler GetHandler(){
	   return handler;
   }
   public InputStream getTexto(){
	   return texto;
   }
}