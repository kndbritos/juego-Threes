package modelo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPuntajes {
	private final Path rutaArchivo = Paths.get("recursos", "mejores_puntajes.txt");
	private final int limiteRanking = 3;
	
	public List<Integer> getPuntajes(){
		List<Integer> puntajes = new ArrayList<Integer>();
		
		if(!Files.exists(rutaArchivo)) return puntajes;
		
		try {
			List<String> lineasArchivo = Files.readAllLines(rutaArchivo);
			for(String linea : lineasArchivo) {
				if(!linea.trim().isEmpty()) puntajes.add(Integer.parseInt(linea.trim()));
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		puntajes.sort(Collections.reverseOrder());
		return puntajes;
	}
	
	public void agregarPuntaje(int nuevoPuntaje) {
		List<Integer> puntajes = getPuntajes();
		puntajes.add(nuevoPuntaje);
		
		puntajes.sort(Collections.reverseOrder());
		
		if(puntajes.size() > limiteRanking) puntajes = puntajes.subList(0, limiteRanking);
		
		List<String> lineas = new ArrayList<String>();
		for(Integer puntaje : puntajes) lineas.add(String.valueOf(puntaje));
		
		try {
			Files.write(rutaArchivo, lineas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public int getMayorPuntaje() {
		List<Integer> puntajes = getPuntajes();
		
		if(puntajes.isEmpty()) return 0;
		
		return puntajes.get(0);	
	}
	
}
