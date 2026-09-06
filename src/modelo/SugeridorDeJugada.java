package modelo;

public class SugeridorDeJugada {
	 public static Direccion sugerir(Tablero tablero) {
	        Direccion mejorDireccion = null;
	        int mejorPuntaje = -1;

	        for (Direccion direccion : Direccion.values()) {
	            Tablero copia = tablero.copia();
	            boolean sePudoMover = copia.mover(direccion);

	            if (sePudoMover) {
	                int puntaje = evaluar(copia);
	                if (puntaje > mejorPuntaje) {
	                    mejorPuntaje = puntaje;
	                    mejorDireccion = direccion;
	                }
	            }
	        }

	        return mejorDireccion;
	    }

	    private static int evaluar(Tablero tableroSimulado) {
	        return tableroSimulado.contarCeldasVacias();
	    }
}
