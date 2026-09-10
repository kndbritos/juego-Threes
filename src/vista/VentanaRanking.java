package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.ControladorJuego;

public class VentanaRanking extends JDialog {
	
	public VentanaRanking(JFrame padre, List<Integer> ranking) {
        setBounds(
            100,
            100,
            280,
            220
        );

        setLocationRelativeTo(padre);

        getContentPane().setLayout(
            new BorderLayout(10, 10)
        );

        crearEncabezado();
        crearListaPuntajes(ranking);
    }

    private void crearEncabezado() {

        JLabel lblTitulo =
            new JLabel(
                "RANKING PUNTAJES",
                SwingConstants.CENTER
            );

        lblTitulo.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                14
            )
        );

        getContentPane().add(
            lblTitulo,
            BorderLayout.NORTH
        );
    }

    private void crearListaPuntajes(List<Integer> ranking) {

    	JPanel panelPuntajes = new JPanel();
    	
    	boolean estaVacio = false;
    	
    	if(ranking == null || ranking.isEmpty()) {
    		estaVacio = true;
    	}
    	    	
        panelPuntajes.setLayout(
            estaVacio ? new BorderLayout() : new GridLayout(3, 1, 5, 5)
        );

        if (estaVacio) {

            JLabel lblSinResultados =
                new JLabel(
                    "No hay resultados",
                    SwingConstants.CENTER
                );

            lblSinResultados.setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    14
                )
            );

            panelPuntajes.add(
                lblSinResultados,
                BorderLayout.CENTER
            );

        } else {

            int cantidadPuntajes = ranking.size();

            for (int i=0; i<3; i++) {
            	
            	String texto;
            	
                if(i < cantidadPuntajes) {
                	texto = (i+1) + "° Puesto: " + ranking.get(i);
                } else {
                	texto = (i+1) + "° Puesto: -";
                }

                JLabel lblPuntaje =
                    new JLabel(
                        texto,
                        SwingConstants.CENTER
                    );

                lblPuntaje.setFont(
                    new Font(
                        "Arial",
                        Font.BOLD,
                        14
                    )
                );

                panelPuntajes.add(lblPuntaje);
            }
        }

        getContentPane().add(
            panelPuntajes,
            BorderLayout.CENTER
        );
    }

}
