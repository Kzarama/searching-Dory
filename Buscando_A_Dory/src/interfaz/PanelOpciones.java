package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class PanelOpciones extends JPanel implements ActionListener {
	/**
	 *	atributos de la clase PanelOpciones
	 */
	public final static String ORDNOM = "ORDNOM", ORDPUN = "ORDPUN", BUSCAR = "BUSCAR", GUARDAR = "GUARDAR", PUNTAJES = "PUNTAJES", INICIO = "INICIO";
	private JLabel labJugador, labNombre, labPuntos, labPuntaje, labNivel, labNiveles;
	private JButton btOrdNom, btOrdPun, btBuscar, btGuardar, btPuntajes, btIniciar;
	private JPanel panel1, panel2;
	private InterfazBuscandoDory interfaz;
	/**
	 *	constructor de la clase PanelOpciones
	 *	@param interfaz
	 */
	public PanelOpciones(InterfazBuscandoDory interfaz) {
		this.interfaz = interfaz;
		
		panel1 = new JPanel(new GridLayout(1, 6));
		TitledBorder border1 = BorderFactory.createTitledBorder("JUEGO");
		border1.setTitleColor(Color.BLUE);
		panel1.setBorder(border1);
		
		labJugador = new JLabel("JUGADOR:");
		labNombre = new JLabel(interfaz.darJugador().getNombre());
		labPuntos = new JLabel("PUNTOS:");
		labPuntaje = new JLabel(interfaz.darJugador().getPuntaje() + "");
		labNivel = new JLabel("NIVEL:");
		labNiveles = new JLabel(interfaz.darJugador().getNivel() + "");
		
		panel1.add(labJugador);
		panel1.add(labNombre);
		panel1.add(labPuntos);
		panel1.add(labPuntaje);
		panel1.add(labNivel);
		panel1.add(labNiveles);
		
		panel2 = new JPanel(new GridLayout(2, 3));
		TitledBorder border2 = BorderFactory.createTitledBorder("OPCIONES");
		border2.setTitleColor(Color.BLUE);
		panel2.setBorder(border2);
		
		btOrdNom = new JButton("ORDENAR POR NOMBRE");
		btOrdPun = new JButton("ORDENAR POR PUNTAJE");
		btBuscar = new JButton("BUSCAR JUGADOR");
		btGuardar = new JButton("GUARDAR");
		btPuntajes = new JButton("VER PUNTAJES");
		btIniciar = new JButton("INICIAR");
		
		btOrdNom.setActionCommand(ORDNOM);
		btOrdNom.addActionListener(this);
		btOrdPun.setActionCommand(ORDPUN);
		btOrdPun.addActionListener(this);
		btBuscar.setActionCommand(BUSCAR);
		btBuscar.addActionListener(this);
		btGuardar.setActionCommand(GUARDAR);
		btGuardar.addActionListener(this);
		btGuardar.setEnabled(false);
		btPuntajes.setActionCommand(PUNTAJES);
		btPuntajes.addActionListener(this);
		btPuntajes.setEnabled(false);
		btIniciar.setActionCommand(INICIO);
		btIniciar.addActionListener(this);
		
		panel2.add(btOrdNom);
		panel2.add(btOrdPun);
		panel2.add(btBuscar);
		panel2.add(btGuardar);
		panel2.add(btPuntajes);
		panel2.add(btIniciar);
		
		JPanel panelaux = new JPanel(new GridLayout(2, 1));
		
		panelaux.add(panel1);
		panelaux.add(panel2);
		
		setLayout(new BorderLayout());
		add(panelaux, BorderLayout.NORTH);
	}
	/**
	 *	puntaje
	 *	@param x
	 *	@param y
	 */
	public void puntaje(int x, int y) {
		for(int i =0; i<interfaz.getPeces().size(); i++){
			int minX = interfaz.getPeces().get(i).getPosX();
			int maxX = minX + 50;
			int minY = interfaz.getPeces().get(i).getPosY();
			int maxY = minY + 50;
			if(x > minX && x < maxX && y > minY && y < maxY) {
				if(interfaz.getPeces().get(i).getTipoPez() == 0) {
					interfaz.darJugador().setPuntaje(interfaz.darJugador().getPuntaje() + 1);
					labPuntaje.setText(interfaz.darJugador().getPuntaje() + "");
					interfaz.getPeces().get(i).setTipoPez(9);
					if(interfaz.darJugador().getPuntaje() == 11) {
						interfaz.darJugador().setNivel(interfaz.darJugador().getNivel() + 1);
						labNiveles.setText(interfaz.darJugador().getNivel() + "");
					} else if(interfaz.darJugador().getPuntaje() == 21) {
						interfaz.darJugador().setNivel(interfaz.darJugador().getNivel() + 1);
						labNiveles.setText(interfaz.darJugador().getNivel() + "");
					} else if(interfaz.darJugador().getPuntaje() == 31) {
						interfaz.darJugador().setNivel(interfaz.darJugador().getNivel() + 1);
						labNiveles.setText(interfaz.darJugador().getNivel() + "");
					} else if(interfaz.darJugador().getPuntaje() == 41) {
						interfaz.darJugador().setNivel(interfaz.darJugador().getNivel() + 1);
						labNiveles.setText(interfaz.darJugador().getNivel() + "");
					}
				} else if(interfaz.getPeces().get(i).getTipoPez() > 0 && interfaz.getPeces().get(i).getTipoPez() < 8) {
					if(interfaz.darJugador().getPuntaje() > 0) {
						interfaz.getPeces().get(i).setTipoPez(9);
						interfaz.darJugador().setPuntaje(interfaz.darJugador().getPuntaje() - 1);
						labPuntaje.setText(interfaz.darJugador().getPuntaje() + "");
					} else {
						interfaz.cerrarApp();
					}
				}
			}
		}
	}
	/**
	 *	actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando == ORDNOM) {
			interfaz.ordenarPorNombre();
		} else if(comando == ORDPUN) {
			interfaz.ordenarPorPuntaje();
		} else if(comando == BUSCAR) {
			try{
				int puntaje = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE VALOR"));
				interfaz.llamarBuscarPuntaje(puntaje);
			} catch (Exception exep) {
			}
		} else if(comando == INICIO) {
			interfaz.moverPeces();
			btIniciar.setEnabled(false);
			btGuardar.setEnabled(true);
			btPuntajes.setEnabled(true);
		} else if(comando == GUARDAR) {
			interfaz.guardarEstadoJuego();
		} else if(comando == PUNTAJES) {
			JOptionPane.showMessageDialog(null, interfaz.darJugador().mostrarPuntajes());
		}
	}

}