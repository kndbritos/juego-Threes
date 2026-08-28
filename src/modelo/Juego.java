package modelo;

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
}
