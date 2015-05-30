package Estructuras;





//definicion del arbol roji-negro
class arbolRojiNegro{
	boolean esta;
	public NodoRojiNegro raiz;
	public static final int rojo=0;
	public static final int negro=1;
	
	//crea el arbol
	public arbolRojiNegro(){
	}
	
	//crea el arbol con la llave
	public arbolRojiNegro(int canti,String nom){
		raiz = new NodoRojiNegro(canti,nom);
		raiz.color = negro;
	}
	
	//busca una palabra dentro de los nodos del arbol
	public boolean buscar(String d, NodoRojiNegro r){  
		ComparaString comparador = new ComparaString(r.Direccion, d);
		while (r != null){
			if(comparador.comparar() == 0) {
				System.out.println(r.Direccion);	
				esta = true;
				break;
				
			}
			buscar(d, r.hIzq);
			buscar(d, r.hDer);
			break;
			
		}
		//System.out.println("Nodo no encontrado");	
		return esta;
	}
	
	//Inserta una llave en el arbol roji-negro
	public NodoRojiNegro Insertar(int canti,String nom, NodoRojiNegro t){
		raiz=t;
		try{          
			if (estaVacio()){
		  		raiz = new NodoRojiNegro(canti,nom);
		  		raiz.color = negro;
			}
			else
		  		raiz = insertaraux(canti,nom,t);
		}
		catch(Exception e){
		}
		return raiz;
	}
	
	//Ayuda al metodo de insertar
	public NodoRojiNegro insertaraux(int canti,String nom, NodoRojiNegro t) {
		try{
			//Insercion normal, y le asigna el padre en otra referencia
			NodoRojiNegro y=null;
			NodoRojiNegro x = t;
			while (x != null){
		  	y = x;
		  	if (canti < x.Cantidad)
		    	x = x.hIzq;
		  	else
		    	x = x.hDer;
			}
			NodoRojiNegro z = new NodoRojiNegro(canti,nom,y);
			if (canti < y.Cantidad)
		 		y.hIzq = z;
			else
		  		y.hDer = z;
			//inserta en el arbol para arreglarlo
			t = insertarArreglado(t, z);
		}
		catch(Exception e){
		}
		return t;
	}
	
	//Recibe la raiz con el elemento metido y el elemento
	//para arreglarlo 
	public NodoRojiNegro insertarArreglado(NodoRojiNegro t, NodoRojiNegro z){
		try{
			
			//si el padre z es rojo
			while ((z.padre != null) && (z.padre.padre != null) && (z.padre.color == rojo)){
			  //si el padre es hijo izquierdo de abuelo
				if (z.padre == z.padre.padre.hIzq){
					NodoRojiNegro y = z.padre.padre.hDer;
			        //si el tio de z tambien es rojo
			        if (y!=null && y.color == rojo){
						//cambia al tio de z negro, al padre de z negro
						
						z.padre.color = negro;
						y.color = negro;
						z.padre.padre.color = rojo;
						z = z.padre.padre;
			        }
			        else {
			        	//Si z es hijo derecho
						if (z.padre.hDer!=null && z == z.padre.hDer) {
							z = z.padre;
							t = rotarIzq(t, z);
						}
						else{
							//Caso 3
							z.padre.color = negro;
							z.padre.padre.color = rojo;
							t = rotarDer(t, z.padre.padre);
						}
			        }
			  	}
		  	//Si el padre de z es hijo derecho
				else{
					NodoRojiNegro y = z.padre.padre.hIzq;
					//si el tio de z es rojo
					if (y!=null && y.color == rojo) {
					  // cambiar colores
					  z.padre.color = negro;
					  y.color = negro;
					  z.padre.padre.color = rojo;
					  z = z.padre.padre;
					}
					else {
					  //si z es hijo izquierdo
					  if (z == z.padre.hIzq) {
					  	
					  	
					    z = z.padre;
					    t = rotarDer(t, z);
					  }
					  else{
					  	
					  	//Caso 3
					  	z.padre.color = negro;
					  	z.padre.padre.color = rojo;
					  	t = rotarIzq(t, z.padre.padre);
					  }
					} 
				}
			}
			
		}
		catch (Exception e){
			
		}
		t.color = negro;
		return t;
	}
	
	//rotacion izquierda
	public NodoRojiNegro rotarIzq(NodoRojiNegro t, NodoRojiNegro x) {
		NodoRojiNegro y = x.hDer;
		x.hDer = y.hIzq;
		if (y.hIzq != null)
		  y.hIzq.padre = x;
		y.padre = x.padre;
		if (x.padre == null)
		  t = y;
		else if (x == x.padre.hIzq)
		  x.padre.hIzq = y;
		else
		  x.padre.hDer = y;
		y.hIzq = x;
		x.padre = y;
		return t;
	}
	
	//rotacion derecha
	public NodoRojiNegro rotarDer(NodoRojiNegro t, NodoRojiNegro x) {
		NodoRojiNegro y = x.hIzq;
		x.hIzq = y.hDer;
		if (y.hDer != null)
		  y.hDer.padre = x;
		y.padre = x.padre;
		if (x.padre == null)
		  t = y;
		else if (x == x.padre.hIzq)
		  x.padre.hIzq = y;
		else
		  x.padre.hDer = y;
		y.hDer = x;
		x.padre = y;
		return t;
	}
	
	//busca un elemento
	public boolean Miembro(int x, NodoRojiNegro r){
		raiz=r;
		boolean si=false;
		NodoRojiNegro temp = raiz;
		while (temp != null && si==false) {
		  if(x==temp.Cantidad){
		  	si=true;
		  }
		  else{
		  	if (x < temp.Cantidad)
		    	temp = temp.hIzq;
		    else
		    	if(x > temp.Cantidad)
		    		temp = temp.hDer;
		  }
		}
		return si;
	} 
	
	//retorna true si el arbol esta vacio
	public boolean estaVacio(){
		return (raiz == null);
	}
	
	//Imprime en inorden
	public void Imprimir(NodoRojiNegro t){
		if(estaVacio())
		  System.out.println("Arbol Vacio");
		else
		  imprimirArbol(t);
	}
	
	//auxiliar
	public void imprimirArbol(NodoRojiNegro t){
		if(t != null){
	      imprimirArbol(t.hIzq);
	      if(t.color==1)
	      	System.out.println(t.Cantidad + " negro");
	      else
	      	System.out.println(t.Cantidad + " rojo");
	      imprimirArbol(t.hDer);
		}
  }
}

