package modelo;

public class Tablero {
	
	private Ficha[][] fichas;
	
	public Tablero() {
		fichas = new Ficha [4][4];
	}
	
	public boolean estaVacia(int fila, int columna) {
		if(fichas[fila][columna]==null) {
			return true;
		}
		
		return false;
	}
	public boolean hayFicha(int fila, int columna) {
	    if (fichas[fila][columna] != null) {
	        return true;
	    }

	    return false;
	}
	
	public void moverIzquierda() {
		  for (int fila = 0; fila < 4; fila++) {
		        for (int columna = 0; columna < 4; columna++) {

		            if (hayFicha(fila, columna) && columna > 0) {
		            	
		            	if (estaVacia(fila, columna - 1)) {
		            	    fichas[fila][columna - 1] = fichas[fila][columna];
		            	    fichas[fila][columna] = null; 
		            	}
		            	else if(fichas[fila][columna].puedeCombinarCon(fichas[fila][columna - 1])) {
		            		 fichas[fila][columna - 1] = fichas[fila][columna].resultadoCombinacion(fichas[fila][columna - 1]);
		            		 fichas[fila][columna] = null;
		            	}	
		            }
		        }
		  }
	}
	
	public void moverDerecha() {
		for(int fila = 0; fila < 4; fila++) {
			for (int columna = 3; columna >= 0; columna--) {
				
				if (hayFicha(fila, columna) && columna < 3) {
					
					if(estaVacia(fila, columna + 1)) {
					    fichas[fila][columna + 1] = fichas[fila][columna];
					    fichas[fila][columna] = null;
					}else if(fichas[fila][columna].puedeCombinarCon(fichas[fila][columna + 1])) {
						fichas[fila][columna+1]=fichas[fila][columna].resultadoCombinacion(fichas[fila][columna + 1]);
						fichas[fila][columna] = null;
					}
				}
			}
		}
	}
}


/*
if (fila > 0 && estaVacia(fila - 1, columna)) {

    fichas[fila - 1][columna] = fichas[fila][columna];
    fichas[fila][columna] = null;
}
if (fila < 3 && estaVacia(fila + 1, columna)) {
    fichas[fila + 1][columna] = fichas[fila][columna];
    fichas[fila][columna] = null;
}*/