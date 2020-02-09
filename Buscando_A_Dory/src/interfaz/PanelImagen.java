package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 17/03/2018
 *
 */
public class PanelImagen extends JPanel {
	/**
	 *	atributos de la clase PanelImagen
	 */
	private ImageIcon imagen;
	private JLabel panelImagen;
	/**
	 * constructor de la clase PanelImagen
	 */
	public PanelImagen() {
		imagen = new ImageIcon("img/img.png");
		panelImagen = new JLabel("");
		panelImagen.setIcon(imagen);
		add(panelImagen);
	}

}