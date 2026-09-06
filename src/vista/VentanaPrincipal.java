package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.ControladorJuego;
import modelo.Direccion;

public class VentanaPrincipal {

    private JFrame frame;


    private PanelTablero panelTablero;

    private JLabel valorScore;
    private JLabel valorBest;
    private JLabel valorNext;

    private JButton btnNuevoJuego;
    
    private ControladorJuego controlador;
    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    VentanaPrincipal window =
                            new VentanaPrincipal();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaPrincipal() {

        controlador = new ControladorJuego();

        initialize();
    }

    private void initialize() {

        frame = new JFrame();

        frame.setBounds(
                100,
                100,
                450,
                550
        );

        frame.setTitle("Threes");

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.getContentPane().setLayout(
                new BorderLayout(10, 10)
        );

        crearPanelInformacion();
        crearPanelTablero();
        crearBotonNuevoJuego();
        agregarTeclado();

        frame.setFocusable(true);
    }

    private void crearPanelInformacion() {

        JPanel panelInformacion = new JPanel();

        panelInformacion.setLayout(
                new GridLayout(2, 3)
        );

        panelInformacion.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        JLabel lblScore =
                crearTitulo("SCORE");

        JLabel lblBest =
                crearTitulo("BEST");

        JLabel lblNext =
                crearTitulo("NEXT");

        valorScore =
                crearValor(
                        String.valueOf(
                                controlador.getPuntaje()
                        )
                );

        valorBest =
                crearValor(
                        String.valueOf(controlador.getMejorPuntaje()));

        valorNext =
                crearValor(
                        String.valueOf(
                                controlador
                                    .getProximaFicha()
                                    .getValor()
                        )
                );

        panelInformacion.add(lblScore);
        panelInformacion.add(lblBest);
        panelInformacion.add(lblNext);

        panelInformacion.add(valorScore);
        panelInformacion.add(valorBest);
        panelInformacion.add(valorNext);

        frame.getContentPane().add(
                panelInformacion,
                BorderLayout.NORTH
        );
    }

    private JLabel crearTitulo(String texto) {

        JLabel label =
                new JLabel(
                        texto,
                        SwingConstants.CENTER
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        return label;
    }

    private JLabel crearValor(String texto) {

        JLabel label =
                new JLabel(
                        texto,
                        SwingConstants.CENTER
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        return label;
    }

    private void crearPanelTablero() {

        panelTablero =
                new PanelTablero(controlador);

        panelTablero.setBackground(
                new Color(
                        230,
                        220,
                        205
                )
        );

        frame.getContentPane().add(
                panelTablero,
                BorderLayout.CENTER
        );
    }

    private void agregarTeclado() {

        frame.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyPressed(
                    KeyEvent e) {

                Direccion direccion = obtenerDireccion(e);

                if(direccion != null) {
                	boolean huboMovimiento = controlador.mover(direccion);
                	
                	if(huboMovimiento) {
                		actualizarVista();
                	}
                }      
            }
        });
    }

    private Direccion obtenerDireccion(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                return Direccion.Izquierda;

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        		return Direccion.Derecha;

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        		return Direccion.Arriba;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        		return Direccion.Abajo;
        }
    	
    	return null;
	}

	private void actualizarVista() {

        panelTablero.repaint();

        valorScore.setText(
                String.valueOf(
                        controlador.getPuntaje()
                )
        );

        valorBest.setText(String.valueOf(controlador.getMejorPuntaje()));
        
        valorNext.setText(
                String.valueOf(
                        controlador
                            .getProximaFicha()
                            .getValor()
                )
        );
        
    }
	
	private void crearBotonNuevoJuego() { 
		
		btnNuevoJuego = new JButton ("NUEVO JUEGO");
		
		btnNuevoJuego.addActionListener(e -> {
			controlador.reiniciarJuego();
			
			valorScore.setText("0");
			
			valorNext.setText(String.valueOf(controlador.getProximaFicha().getValor()));
			
			panelTablero.repaint();
			
			frame.requestFocusInWindow();
		});
		
		frame.getContentPane().add(btnNuevoJuego,BorderLayout.SOUTH);
	}
}