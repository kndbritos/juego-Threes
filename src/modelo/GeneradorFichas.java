package modelo;

import java.util.Random;

public class GeneradorFichas {
	private Random random;
	private Ficha proximaFicha;
	
	public GeneradorFichas() {
		random = new Random();
		proximaFicha = generarFicha();
	}
	
	private Ficha generarFicha() {
		return new Ficha(random.nextInt(3) + 1);
		
	}
	
	public Ficha getProximaFicha() {
		return proximaFicha;
	}
	
	public Ficha tomarYGenerarSiguiente() {
		Ficha fichaTomar = proximaFicha;
		proximaFicha = generarFicha();
		return fichaTomar;
	}
}
