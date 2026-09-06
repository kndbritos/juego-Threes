package vista;

import modelo.Tablero;

public class Ventana extends java.awt.Frame {

    private PanelTablero panel;

    public Ventana(Tablero tablero) {

        setTitle("Threes");
        setSize(450, 550);
        setLocation(300, 100);

        crearInformacion();

        panel = new PanelTablero(tablero);
        add(panel);

        agregarCierre();
    }

    private void crearInformacion() {

        java.awt.Panel informacion = new java.awt.Panel();

        informacion.setLayout(
                new java.awt.GridLayout(1, 3));

        agregarInformacion(informacion, "SCORE", "0");
        agregarInformacion(informacion, "BEST", "0");
        agregarInformacion(informacion, "NEXT", "1");

        add(informacion, java.awt.BorderLayout.NORTH);
    }

    private void agregarInformacion(
            java.awt.Panel panel,
            String titulo,
            String valor) {

        java.awt.Label etiqueta =
                new java.awt.Label(
                        titulo,
                        java.awt.Label.CENTER);

        java.awt.Label numero =
                new java.awt.Label(
                        valor,
                        java.awt.Label.CENTER);

        etiqueta.setFont(new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                14));

        numero.setFont(new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                20));

        panel.add(etiqueta);
        panel.add(numero);
    }

    private void agregarCierre() {

        addWindowListener(
                new java.awt.event.WindowAdapter() {

            public void windowClosing(
                    java.awt.event.WindowEvent e) {

                System.exit(0);
            }
        });
    }
}