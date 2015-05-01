package Parseo;

import java.net.ContentHandler;
import java.util.StringTokenizer;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.tika.sax.BodyContentHandler;
public class Separar {
	
	StringTokenizer tokens;

	public Separar(String name) {
		//String[] separadores = {".",",",":",";","“","'","(",")","[","]","{","}","¿","?","¡","!","…","-","<",">","+","-","*","/","=","\"","«","»","“","”","‘","’"};
		tokens = new StringTokenizer(name);// Recibe un String y lo separa
		// por comas
		
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
