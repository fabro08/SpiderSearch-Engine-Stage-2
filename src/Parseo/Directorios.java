package Parseo;

import java.io.File;

public class Directorios {
	public File[] ficheros;
	String cadena;
	
	public String Dir(File f, String separador) {
		ficheros = f.listFiles();
		int x=0;		
		while(x<ficheros.length){
			
     //   for (int x=0;x<ficheros.length;x++){      
        	if (ficheros[x].isFile()){
        		if (ficheros[x].getName().endsWith(".pdf")|
        			ficheros[x].getName().endsWith(".docx")|
        			ficheros[x].getName().endsWith(".doc")|
        			ficheros[x].getName().endsWith(".txt")|
        			ficheros[x].getName().endsWith(".odt")){
        		return "/"+ficheros[x].getName();
        
        		}
        	}
			
			if (ficheros[x].isDirectory()) {
				String separ = separador + " ";
				Dir(ficheros[x], separ);
				
			}
			x++;
			
		}
        return separador;
	}
    public String GetCadena(){
    		return cadena;
	}
	
	
}
