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
	public boolean mover(Direccion direccion) {
	    boolean huboMovimiento = false;
	    int desplazamientoFila = direccion.getDireccionFila();
	    int desplazamientoColumna = direccion.getDireccionColumna();
	    int[] rangoFilas = calcularRangoRecorrido(desplazamientoFila);
	    int[] rangoColumnas = calcularRangoRecorrido(desplazamientoColumna);

	    int inicioFila = rangoFilas[0];
	    int finFila = rangoFilas[1];
	    int pasoFila = rangoFilas[2];

	    int inicioColumna = rangoColumnas[0];
	    int finColumna = rangoColumnas[1];
	    int pasoColumna = rangoColumnas[2];

	    for (int fila = inicioFila; fila != finFila; fila += pasoFila) {
	        for (int columna = inicioColumna; columna != finColumna; columna += pasoColumna) {
	            if (moverFicha(fila, columna, desplazamientoFila, desplazamientoColumna)) {
	                huboMovimiento = true;
	            }
	        }
	    }
	    return huboMovimiento;
	}

	private int[] calcularRangoRecorrido(int desplazamiento) {
	    if (desplazamiento > 0) {
	        return new int[] { 3, -1, -1 };
	    }
	    return new int[] { 0, 4, 1 };
	}

	private boolean moverFicha(int fila, int columna, int desplazamientoFila, int desplazamientoColumna) {
	    if (!hayFicha(fila, columna)) {
	        return false;
	    }

	    int filaDestino = fila + desplazamientoFila;
	    int columnaDestino = columna + desplazamientoColumna;
	    if (!esPosicionValida(filaDestino, columnaDestino)) {
	        return false;
	    }

	    if (estaVacia(filaDestino, columnaDestino)) {
	        fichas[filaDestino][columnaDestino] = fichas[fila][columna];
	        fichas[fila][columna] = null;
	        return true;
	    }

	    Ficha fichaOrigen = fichas[fila][columna];
	    Ficha fichaDestino = fichas[filaDestino][columnaDestino];
	    if (fichaOrigen.puedeCombinarCon(fichaDestino)) {
	        fichas[filaDestino][columnaDestino] = fichaOrigen.resultadoCombinacion(fichaDestino);
	        fichas[fila][columna] = null;
	        return true;
	    }
	    return false;
	}

	private boolean esPosicionValida(int fila, int columna) {
	    if (fila < 0 || fila > 3) {
	        return false;
	    }
	    if (columna < 0 || columna > 3) {
	        return false;
	    }
	    return true;
	}
	public boolean estaLleno() {
		for (int fila = 0; fila < fichas.length; fila++) {
	        for (int columna = 0; columna < fichas[fila].length; columna++) {
	            if (!hayFicha(fila, columna)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	public boolean hayMovimientos() {
		if(!estaLleno()) {
			return true;
		}
		boolean movimiento=false;
		for (int fila = 0; fila < fichas.length; fila++) {
	        for (int columna = 0; columna < fichas[fila].length; columna++) {
	        	movimiento|=fichaTieneCombinaciones(fila,columna);
	        }
	    }
		return movimiento;
	}
	public boolean fichaTieneCombinaciones(int fila,int columna) {
		if(esPosicionValida(fila+1,columna) && fichas[fila][columna].puedeCombinarCon(fichas[fila+1][columna])) {
			return true;
		}
		if(esPosicionValida(fila-1,columna) && fichas[fila][columna].puedeCombinarCon(fichas[fila-1][columna])) {
			return true;
		}
		if(esPosicionValida(fila,columna+1) && fichas[fila][columna].puedeCombinarCon(fichas[fila][columna+1])) {
			return true;
		}
		if(esPosicionValida(fila,columna-1) && fichas[fila][columna].puedeCombinarCon(fichas[fila][columna-1])) {
			return true;
		}
		return false;
	}
	
	public void colocarFicha(int fila, int columna, Ficha ficha) {
		if(esPosicionValida(fila, columna) && estaVacia(fila, columna)) {
			fichas[fila][columna] = ficha;
		}
	}
	
	public Ficha getFicha(int fila,int columna) {
		return fichas[fila][columna];
	}
	public int calcularPuntaje() {
	    int total = 0;
	    for (int fila = 0; fila < fichas.length; fila++) {
	        for (int columna = 0; columna < fichas[fila].length; columna++) {
	            if (hayFicha(fila, columna)) {
	                total += fichas[fila][columna].obtenerPuntaje();
	            }
	        }
	    }
	    return total;
	}
	
	
}

