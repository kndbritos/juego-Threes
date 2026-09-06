package modelo;

import java.util.Random;

public class Juego {
	private Tablero tablero;
	private GeneradorFichas generadorFichas;
	private int puntaje;
	
	public Juego() {
		tablero = new Tablero();
		generadorFichas = new GeneradorFichas();
		puntaje = 0;
		
		/* Esto se puede cambiar. Habría que decidir si las fichas empezarían en el medio siempre o en dos posiciones random*/
		tablero.colocarFicha(1, 1, generadorFichas.tomarYGenerarSiguiente());
		tablero.colocarFicha(2, 1, generadorFichas.tomarYGenerarSiguiente());
	}
	private void agregarNuevaFicha(Direccion direccion) {
	    Random random = new Random();

	    int fila;
	    int columna;

	    if (direccion == Direccion.Izquierda) {
	        columna = 3;
	        fila = random.nextInt(4);
	    } 
	    else if (direccion == Direccion.Derecha) {
	        columna = 0;
	        fila = random.nextInt(4);
	    } 
	    else if (direccion == Direccion.Arriba) {
	        fila = 3;
	        columna = random.nextInt(4);
	    } 
	    else {
	        fila = 0;
	        columna = random.nextInt(4);
	    }

	    while (!tablero.estaVacia(fila, columna)) {
	        if (direccion == Direccion.Izquierda || direccion == Direccion.Derecha) {
	            fila = random.nextInt(4);
	        } else {
	            columna = random.nextInt(4);
	        }
	    }

	    tablero.colocarFicha(fila, columna,generadorFichas.tomarYGenerarSiguiente()
	    );
	}
	public boolean realizarMovimiento(Direccion direccion) {
		boolean huboMovimiento = tablero.mover(direccion);
		
		if(huboMovimiento) {
			agregarNuevaFicha(direccion);
			actualizarPuntaje();
		}
		
		return huboMovimiento;
	}
	public void actualizarPuntaje() {
		puntaje=tablero.calcularPuntaje();
	}
	public int getPuntaje() {
		return puntaje;
	}
	
	public boolean getEstado() {
		return tablero.hayMovimientos();
	}
	
	public Ficha getProximaFicha() {
		return generadorFichas.getProximaFicha();
	}
	public Direccion sugerirMovimiento() {
	    return SugeridorDeJugada.sugerir(tablero);
	}
	public int obtenerValor(int fila, int columna) {
		return tablero.obtenerValor(fila, columna);
	}
}
