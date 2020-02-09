package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 17/03/2018
 *
 */
public class PanelJuego extends JPanel implements MouseListener {
	/**
	 *	atributos de la clase PanelJuego
	 */
	private Image imagenFondo, imagenPez1, imagenPez2, imagenPez3, imagenPez4, imagenPez5, imagenPez6, imagenPez7, imagenPez8;
	private InterfazBuscandoDory interfaz;
	/**
	 *	costructor de la clase PanelJuego
	 *	@param interfaz
	 */
	public PanelJuego(InterfazBuscandoDory interfaz) {
		this.interfaz = interfaz;
		imagenFondo = new ImageIcon("img/i.jpeg").getImage();
		imagenPez1 = new ImageIcon("img/pez.png").getImage();
		imagenPez2 = new ImageIcon("img/pez1.png").getImage();
		imagenPez3 = new ImageIcon("img/pez2.png").getImage();
		imagenPez4 = new ImageIcon("img/pez3.png").getImage();
		imagenPez5 = new ImageIcon("img/pez4.png").getImage();
		imagenPez6 = new ImageIcon("img/pez5.png").getImage();
		imagenPez7 = new ImageIcon("img/pez6.png").getImage();
		imagenPez8 = new ImageIcon("img/pez7.png").getImage();
		addMouseListener(this);
	}
	/**
	 *	paintComponent
	 */
	public void paintComponent(Graphics g){
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		for(int i =0; i<interfaz.getPeces().size(); i++){
			if(interfaz.getPeces().get(i).getTipoPez() == 0) {
				g.drawImage(imagenPez1, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 1) {
				g.drawImage(imagenPez2, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 2) {
				g.drawImage(imagenPez3, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 3) {
				g.drawImage(imagenPez4, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 4) {
				g.drawImage(imagenPez5, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 5) {
				g.drawImage(imagenPez6, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 6) {
				g.drawImage(imagenPez7, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			} else if (interfaz.getPeces().get(i).getTipoPez() == 7) {
				g.drawImage(imagenPez8, interfaz.getPeces().get(i).getPosX(), interfaz.getPeces().get(i).getPosY(), 60, 60, this);
			}
		}
	}
	/**
	 *	mouseClicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	/**
	 *	mouseEntered
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	/**
	 *	mouseExited
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}
	/**
	 *	mousePressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		interfaz.coordenadas(x, y);
	}
	/**
	 *	mouseReleased
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

}