package vista;

import modelo.Tablero;

public class PanelTablero extends java.awt.Canvas {

    private Tablero tablero;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        setBackground(new java.awt.Color(230, 220, 205));
    }

    public void paint(java.awt.Graphics g) {

        for (int fila = 0; fila < 4; fila++) {

            for (int columna = 0; columna < 4; columna++) {

                int x = columna * 90 + 10;
                int y = fila * 90 + 10;

                g.setColor(new java.awt.Color(205, 195, 180));

                g.fillRoundRect(x, y, 80, 80, 15, 15);

                int valor = tablero.obtenerValor(fila, columna);

                if (valor != 0) {

                    dibujarFicha(g, valor, x, y);
                }
            }
        }
    }

    private void dibujarFicha(
            java.awt.Graphics g,
            int valor,
            int x,
            int y) {

        if (valor == 1) {
            g.setColor(new java.awt.Color(245, 190, 120));
        } else if (valor == 2) {
            g.setColor(new java.awt.Color(245, 215, 120));
        } else if (valor == 3) {
            g.setColor(new java.awt.Color(110, 180, 220));
        } else {
            g.setColor(new java.awt.Color(100, 150, 200));
        }

        g.fillRoundRect(x, y, 80, 80, 15, 15);

        g.setColor(java.awt.Color.WHITE);

        g.setFont(new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                28));

        g.drawString("" + valor, x + 32, y + 50);
    }
}