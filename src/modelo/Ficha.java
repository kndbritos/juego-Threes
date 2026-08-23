package modelo;

public class Ficha {
	
	private int valor;
	
	public Ficha(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public boolean puedeCombinarCon(Ficha otra) {
		if ((valor == 1 && otra.getValor() == 2) ||
			    (valor == 2 && otra.getValor() == 1)) {
			    return true;
		}
		
		if(valor==otra.getValor() || valor%3 == 0) {
			return true;
		}
	
		return false;
	}
	
	public Ficha resultadoCombinacion(Ficha otra) {
		if(puedeCombinarCon(otra)) {
			return new Ficha(valor + otra.getValor());
		}
		return null;
	}
}