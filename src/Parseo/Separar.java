package Parseo;

import java.net.ContentHandler;
import java.util.StringTokenizer;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.tika.sax.BodyContentHandler;
public class Separar {
	TikaParser eParser = new TikaParser();
	String a= String.valueOf(eParser.GetHandler());
	StringTokenizer tokens;
	int i =0;

	public Separar(String name) {
		String[] separadores = {"",",",":",";","“","'","(",")","[","]","{","}","¿","?","¡","!","…","-","<",">","+","-","*","/","=","\"","«","»","“","”","‘","’"};
		int i = 0;
		String txt;
		

		while(i<separadores.length){
			txt = CicloToken(name, separadores[i]);
			name = txt;
			i++;
	
		}
		// por comas
		tokens = new StringTokenizer(name,separadores[i]);// Recibe un String y lo separa
		while (tokens.hasMoreTokens()){// Mientras haya tokens
			tokens.nextToken();// Retorne el token siguiente
	}
	}

	/**
	 * Método para manejar el ciclo
	 */
	public String CicloToken(String txt, String separador) {
		StringTokenizer noSigns = new StringTokenizer(txt, separador);
		String textToken = "";
		while(noSigns.hasMoreTokens()){
			textToken = textToken + " " + noSigns.nextToken().toString();	
		}	
		return textToken;
	}

	}
