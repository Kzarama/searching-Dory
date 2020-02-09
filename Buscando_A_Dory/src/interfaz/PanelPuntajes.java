package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelPuntajes extends JPanel {
	
	private JList lista;
	private JScrollPane scroll;
	
	public PanelPuntajes() {
		setLayout(new BorderLayout());
		
		lista = new JList();
		scroll = new JScrollPane(lista);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);
	}
	
	public void refrescarLista(ArrayList n) {
		lista.setListData(n.toArray());
		lista.setSelectedIndex(0);
	}
}