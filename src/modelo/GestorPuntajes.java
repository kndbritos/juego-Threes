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
		List<Integer> listaPuntajes = new ArrayList<Integer>();
		
		if(!Files.exists(rutaArchivo)) return listaPuntajes;
		
		try {
			List<String> lineasArchivo = Files.readAllLines(rutaArchivo);
			for(String linea : lineasArchivo) {
				if(!linea.trim().isEmpty()) listaPuntajes.add(Integer.parseInt(linea.trim()));
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		listaPuntajes.sort(Collections.reverseOrder());
		return listaPuntajes;
	}
	
	public void agregarPuntaje(int nuevoPuntaje) {
		List<Integer> listaPuntajes = getPuntajes();
		listaPuntajes.add(nuevoPuntaje);
		
		listaPuntajes.sort(Collections.reverseOrder());
		
		if(listaPuntajes.size() > limiteRanking) listaPuntajes = listaPuntajes.subList(0, limiteRanking);
		
		List<String> lineas = new ArrayList<String>();
		for(Integer puntaje : listaPuntajes) lineas.add(String.valueOf(puntaje));
		
		try {
			Files.write(rutaArchivo, lineas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
}
