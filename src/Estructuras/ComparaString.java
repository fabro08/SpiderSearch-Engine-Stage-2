package Estructuras;

import java.text.Collator;

public class ComparaString {
	String a;
	String b;

	
	public ComparaString(String a, String b){
		this.a = a;
		this.b = b;
	}
	public int comparar(){		
		Collator comparador = Collator.getInstance();
		comparador.setStrength(Collator.PRIMARY);
		return comparador.compare(a, b);
	}
	

}
