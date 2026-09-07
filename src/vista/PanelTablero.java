package vista;

import controlador.ControladorJuego;

public class PanelTablero extends javax.swing.JPanel {

    private ControladorJuego controlador;
    private boolean gameOver;

    public PanelTablero(ControladorJuego controlador) {

        this.controlador = controlador;

        setBackground(
            new java.awt.Color(230, 220, 205)
        );
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {

        super.paintComponent(g);
        
        int anchoTablero = 4 * 90;
        int altoTablero = 4 * 90;

        int inicioX = (getWidth() - anchoTablero) / 2;
        int inicioY = (getHeight() - altoTablero) / 2;

        for (int fila = 0; fila < 4; fila++) {

            for (int columna = 0; columna < 4; columna++) {

            	int x = inicioX + columna * 90 + 5;
            	int y = inicioY + fila * 90 + 5;

                g.setColor(
                    new java.awt.Color(205, 195, 180)
                );

                g.fillRoundRect(
                    x,
                    y,
                    80,
                    80,
                    15,
                    15
                );

                int valor =
                    controlador.obtenerValor(
                        fila,
                        columna
                    );

                if (valor != 0) {

                    dibujarFicha(
                        g,
                        valor,
                        x,
                        y
                    );
                }
            }
        }
        if (gameOver) {
            dibujarGameOver(g);
        }
    }

    private void dibujarFicha(
            java.awt.Graphics g,
            int valor,
            int x,
            int y) {

        if (valor == 1) {

            g.setColor(
                new java.awt.Color(245, 190, 120)
            );

        } else if (valor == 2) {

            g.setColor(
                new java.awt.Color(245, 215, 120)
            );

        } else if (valor == 3) {

            g.setColor(
                new java.awt.Color(110, 180, 220)
            );

        } else {

            g.setColor(
                new java.awt.Color(100, 150, 200)
            );
        }

        g.fillRoundRect(
            x,
            y,
            80,
            80,
            15,
            15
        );

        g.setColor(
            java.awt.Color.WHITE
        );

        g.setFont(
            new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                28
            )
        );

        String texto = String.valueOf(valor);

        java.awt.FontMetrics metricas = g.getFontMetrics();

        int anchoTexto = metricas.stringWidth(texto);
        int altoTexto = metricas.getAscent();

        int textoX = x + (80 - anchoTexto) / 2;
        int textoY = y + (80 + altoTexto) / 2 - 3;

        g.drawString(texto, textoX, textoY);
    }
    
    private void dibujarGameOver(java.awt.Graphics g) {

        g.setColor(
            new java.awt.Color(100, 100, 100, 180)
        );

        g.fillRect(
            0,
            0,
            getWidth(),
            getHeight()
        );

        g.setColor(java.awt.Color.WHITE);

        g.setFont(
            new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                32
            )
        );

        String texto = "GAME OVER";

        java.awt.FontMetrics metricas = g.getFontMetrics();

        int x = (getWidth() - metricas.stringWidth(texto)) / 2;
        int y = getHeight() / 2 - 10;

        g.drawString(texto, x, y);

        g.setFont(
            new java.awt.Font(
                "Arial",
                java.awt.Font.BOLD,
                20
            )
        );

        texto = "Score: " + controlador.getPuntaje();

        metricas = g.getFontMetrics();

        x = (getWidth() - metricas.stringWidth(texto)) / 2;
        y += 35;

        g.drawString(texto, x, y);
    }
    
    public void mostrarGameOver() {
        gameOver = true;
        repaint();
    }
    public void ocultarGameOver() {
        gameOver = false;
        repaint();
    }
}
