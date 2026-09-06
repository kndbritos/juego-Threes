package vista;

import modelo.Tablero;

public class MainPrueba {

    public static void main(String[] args) {

        Tablero tablero = new Tablero();

        Ventana ventana = new Ventana(tablero);

        ventana.setVisible(true);
    }
}