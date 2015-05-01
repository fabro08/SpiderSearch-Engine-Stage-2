package Parseo;

import java.util.StringTokenizer;

public class Separar {
	public void separates(String text){
		String[] separadores = {".",",",":",";","“","'","(",")","[","]","{","}","¿","?","¡","!","…","-","<",">","+","-","*","/","=","\"","«","»","“","”","‘","’"};	
		int i = 0;
		String txt;
		while(i<separadores.length){
			txt = getWords(text, separadores[i]);
			text = txt;
			i++;
		}
		StringTokenizer token = new StringTokenizer(text," ");
		
		while (token.hasMoreTokens()){
			
				
			
		}
	}
	
	private String getWords(String text, String separador){
		StringTokenizer noSigns = new StringTokenizer(text, separador);
		String textToken = "";
		while(noSigns.hasMoreTokens()){
			textToken = textToken + " " + noSigns.nextToken().toString();	
		}	
		return textToken;
}
}
