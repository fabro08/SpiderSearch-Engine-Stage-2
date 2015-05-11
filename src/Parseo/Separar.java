package Parseo;

import java.net.ContentHandler;
import java.util.StringTokenizer;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.tika.sax.BodyContentHandler;
import Estructuras.ArbolAVL;

/**
 * Clase para separar las palabras
 * @author fabricio
 */
public class Separar {
	/**Atributos de las clase*/
	StringTokenizer tokens;
	Peso aPeso = new Peso();
	
	/**Metodo para separar y constructor de la clase
	 * @param texto*/
	public Separar(String name) {
		aPeso.SetPeso();
		String[] separadores = {".","●",",",":",";","“","'","(",")","[","]","{","}","¿","?","¡","!","…","-","<",">","+","-","*","/","=","\"","«","»","“","”","‘","’"};	
		int i = 0;
		int j =0;
		String txt;
		while(i<separadores.length){
			txt = getWords(name, separadores[i]);
			name = txt;
			i++;
		}
		StringTokenizer token = new StringTokenizer(name," ");
		ArbolAVL arbolito = new ArbolAVL();
		while (token.hasMoreTokens()){
					arbolito.insertar(token.nextToken(),j);
					j++;
				
			
		}
		
		arbolito.inOrden(arbolito.obtenerRaiz());
	}
	/**Metodo para obtener las palabras ya separadas 
	 * @param texto y el separador
	 * @return texto separado
	 */
	private String getWords(String text, String separador){
		StringTokenizer noSigns = new StringTokenizer(text, separador);
		String textToken = "";
		
		while(noSigns.hasMoreTokens()){
			textToken = textToken + " " + noSigns.nextToken().toString();	
		}	
		return textToken;
	}

	/**
	 * Método para manejar el ciclo
	 */
	public Object CicloToken() {
		while (tokens.hasMoreTokens()) {// Mientras haya tokens
				 System.out.println(tokens.nextToken());// Retorne el token siguiente
		}
		return "a";

	}

	}
