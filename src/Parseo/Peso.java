package Parseo;

import java.util.Random;

public class Peso {
	
	Random peso = new Random();
	Integer pes = 0;
	public void  SetPeso(){
		 pes= peso.nextInt(1000);
	}
	public Integer GetPeso(){
		return pes;
	}
	
}
