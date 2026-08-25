package modelo;
 
public enum Direccion {
	Izquierda(0, -1),Derecha(0, 1),Arriba(-1, 0),Abajo(1, 0);
 
	private final int direccionFila;
	private final int direccionColumna;
 
	Direccion(int direccionFila, int direccionColumna) {
		this.direccionFila = direccionFila;
		this.direccionColumna = direccionColumna;
	}
 
	public int getDireccionFila() {
		return direccionFila;
	}
 
	public int getDireccionColumna() {
		return direccionColumna;
	}
}