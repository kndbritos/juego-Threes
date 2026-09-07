package controlador;

import modelo.Direccion;
import modelo.Ficha;
import modelo.Juego;

public class ControladorJuego {

    private Juego juego;
    
    private int mejorPuntaje;
    
    public ControladorJuego() {
        this.juego = new Juego();
        mejorPuntaje = 0;
    }

    public boolean mover(Direccion direccion) {
    	boolean huboMovimiento = juego.realizarMovimiento(direccion);
    	
    	if(huboMovimiento) {
    		actualizarMejorPuntaje();
    	}
    	
    	return huboMovimiento;
    }

    private void actualizarMejorPuntaje() {
		
    	if(juego.getPuntaje() > mejorPuntaje) {
    		mejorPuntaje = juego.getPuntaje();
    	}
		
	}
    public int getMejorPuntaje() {
    	return mejorPuntaje;
    }
	public int getPuntaje() {
        return juego.getPuntaje();
    }

    public Ficha getProximaFicha() {
        return juego.getProximaFicha();
    }

    public int obtenerValor(int fila, int columna) {
        return juego.obtenerValor(fila, columna);
    }

    public boolean juegoTerminado() {
        return !juego.getEstado();
    }
    public void reiniciarJuego() {
    	juego = new Juego();
    }
}