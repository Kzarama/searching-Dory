package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.JugadorNoExisteException;
import hilos.HiloPez;
import modelo.Jugador;
import modelo.OrdenarPorNombre;
import modelo.Pez;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 17/03/2018
 *
 */
public class InterfazBuscandoDory extends JFrame {
	/**
	 *	atributos de la clase InterfazBuscandoDory
	 */
	private PanelImagen panImagen;
	private PanelJuego panJuego;
	private PanelOpciones panOpciones;
	private ArrayList<Pez> peces;
	private Jugador jugador, ju;
	private PanelPuntajes panPuntajes;
	private OrdenarPorNombre ordenarNombre;
	/**
	 *	constructor de la clase InterfazBuscandoDory
	 */
	public InterfazBuscandoDory() {
		String[] opciones = {"EMPEZAR NUEVO JUEGO", "CONTINUAR JUEGO"};
		int seleccion = JOptionPane.showOptionDialog(null, "¿QUIERE?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if(seleccion == 0) {
			String nombre = JOptionPane.showInputDialog("INGRESE NOMBRE DE USUARIO:");
			jugador = new Jugador(nombre, 0, 1);
		} else if(seleccion == 1){
			cargarEstadoJuego();
		} else {
			System.exit(0);
		}
		
		panImagen = new PanelImagen();
		panJuego = new PanelJuego(this);
		panOpciones = new PanelOpciones(this);
		panPuntajes = new PanelPuntajes();
		
		setTitle("BUSCANDO A DORY");
		setSize(688, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		JPanel panAux = new JPanel(new GridLayout(2, 1));
		
		panAux.add(panOpciones);
		panAux.add(panPuntajes);
		add(panImagen, BorderLayout.NORTH);
		add(panJuego, BorderLayout.CENTER);
		add(panAux, BorderLayout.SOUTH);
		
		peces = new ArrayList<Pez>();
	}
	/**
	 *	getPeces
	 *	@return peces
	 */
	public ArrayList<Pez> getPeces(){
		return peces;
	}
	/**
	 *	moverPeces
	 */
	public void moverPeces(){
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		peces.add(new Pez());
		HiloPez hiloPez = new HiloPez(this);
		hiloPez.start();
	}
	/**
	 *	coordenadas
	 *	@param x
	 *	@param y
	 */
	public void coordenadas(int x, int y) {
		panOpciones.puntaje(x, y);
	}
	/**
	 *	cerrarApp
	 */
	public void cerrarApp() {
		JOptionPane.showMessageDialog(null, "FIN DEL JUEGO");
		System.exit(0);
	}
	/**
	 *	darJugador
	 *	@return jugador
	 */
	public Jugador darJugador() {
		return jugador;
	}
	/**
	 *	guardarEstadoJuego
	 */
	public void guardarEstadoJuego() {
		
		FileInputStream fileInStr = null;
		ObjectInputStream entrada = null;
		
		FileOutputStream fileOutS = null;
		ObjectOutputStream salida = null;
		
		ArrayList<Jugador> pers = new ArrayList<Jugador>();
		
		try {
			fileInStr = new FileInputStream("archivos/jugadores.dat");
			entrada = new ObjectInputStream(fileInStr);
	        while((ju = (Jugador) entrada.readObject()) != null) {
	        	if(!(ju.getNombre().equals(jugador.getNombre()))) {
	        		pers.add(ju);
	        	}
	        }
		} catch (Exception e) {
		} finally {
            try {
                if (fileInStr != null) {
                	fileInStr.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
            }
		}
		
		try {
			fileOutS = new FileOutputStream("archivos/jugadores.dat");
	        salida = new ObjectOutputStream(fileOutS);
			for(int i = 0; i < pers.size(); i++) {
				salida.writeObject(pers.get(i));
			}
			salida.writeObject(jugador);
			JOptionPane.showMessageDialog(null, "SE HA GUARDADO CON EXITO!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
		} finally {
            try {
                if (fileOutS != null) {
                	fileOutS.close();
                }
                if (salida != null) {
                	salida.close();
                }
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
            }
		}
	}
	/**
	 *	cargarEstadoJuego
	 */
	public void cargarEstadoJuego() {
		ArrayList<Jugador> pers = new ArrayList<Jugador>();
		FileInputStream fileInStr = null;
		ObjectInputStream entrada = null;
		int var = 0;
		
		try {
			fileInStr = new FileInputStream("archivos/jugadores.dat");
			entrada = new ObjectInputStream(fileInStr);
	        while((ju = (Jugador) entrada.readObject()) != null) {
	            pers.add(ju);
	            var++;
	        }
		} catch(Exception e) {
		} finally {
            try {
                if (fileInStr != null) {
                	fileInStr.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
            }
		}
		FileOutputStream fileOutS = null;
		ObjectOutputStream salida = null;
		
		try {
			
			String[] opciones = new String[++var];
	        for(int i = 0; i < pers.size(); i++) {
	        	opciones[i] = pers.get(i).getNombre() + "-" + pers.get(i).getPuntaje() + "-" + pers.get(i).getNivel();
	        }
	        opciones[--var] = "BORRAR PUNTAJES";
	        String resp = (String) JOptionPane.showInputDialog(null, "SELECCIONE UNA OPCION", "", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
	        if(resp == null) {
	        	System.exit(0);
	        } else if(resp == "BORRAR PUNTAJES") {
	    		fileOutS = new FileOutputStream("archivos/jugadores.dat");
	    		salida = new ObjectOutputStream(fileOutS);
				salida.writeObject(null);
	        	System.exit(0);
	        }
	        String[] variable = resp.split("-");
	        jugador = new Jugador(variable[0], Integer.parseInt(variable[1]), Integer.parseInt(variable[2]));
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
		} finally {
            try {
                if (fileOutS != null) {
                	fileOutS.close();
                }
                if (salida != null) {
                	salida.close();
                }
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR,\n POR FAVOR VUELVA A INTENTARLO");
            }
		}
	}
	public void ordenarPorNombre() {
		FileInputStream fileInStr = null;
		ObjectInputStream entrada = null;
		FileOutputStream fileOutS = null;
		ObjectOutputStream salida = null;
		ArrayList<Jugador> pers = new ArrayList<Jugador>();
		try {
			fileInStr = new FileInputStream("archivos/jugadoresTotales.dat");
			entrada = new ObjectInputStream(fileInStr);
			pers.add(jugador);
			while((ju = (Jugador) entrada.readObject()) != null) {
	        	if(!(ju.getNombre().equals(jugador.getNombre()))) {
	        		pers.add(ju);
	        	}
	        }
		} catch (Exception e) {
		} finally {
            try {
                if (fileInStr != null) {
                	fileInStr.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            }
		}
		try {
			fileOutS = new FileOutputStream("archivos/jugadoresTotales.dat");
	        salida = new ObjectOutputStream(fileOutS);
			for(int i = 0; i < pers.size(); i++) {
				salida.writeObject(pers.get(i));
			}
		} catch (Exception e) {
		} finally {
            try {
                if (fileOutS != null) {
                	fileOutS.close();
                }
                if (salida != null) {
                	salida.close();
                }
            } catch (IOException e) {
            }
		}
		for(int i = 1; i < pers.size(); i++) {
			ordenarNombre = new OrdenarPorNombre();
			Jugador porInsertar = (Jugador)pers.get(i);
			for(int j = i; j > 0; j--) {
				Jugador actual = (Jugador) pers.get(j-1);
				if(ordenarNombre.compare(actual, porInsertar) > 0) {
					pers.set(j, actual);
					pers.set(j-1, porInsertar);
				}
			}
		}
		panPuntajes.refrescarLista(pers);
	}
	public void ordenarPorPuntaje() {
		FileInputStream fileInStr = null;
		ObjectInputStream entrada = null;
		FileOutputStream fileOutS = null;
		ObjectOutputStream salida = null;
		ArrayList<Jugador> pers = new ArrayList<Jugador>();
		try {
			fileInStr = new FileInputStream("archivos/jugadoresTotales.dat");
			entrada = new ObjectInputStream(fileInStr);
			pers.add(jugador);
			while((ju = (Jugador) entrada.readObject()) != null) {
	        	if(!(ju.getNombre().equals(jugador.getNombre()))) {
	        		pers.add(ju);
	        	}
	        }
		} catch (Exception e) {
		} finally {
            try {
                if (fileInStr != null) {
                	fileInStr.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            }
		}
		try {
			fileOutS = new FileOutputStream("archivos/jugadoresTotales.dat");
	        salida = new ObjectOutputStream(fileOutS);
			for(int i = 0; i < pers.size(); i++) {
				salida.writeObject(pers.get(i));
			}
		} catch (Exception e) {
		} finally {
            try {
                if (fileOutS != null) {
                	fileOutS.close();
                }
                if (salida != null) {
                	salida.close();
                }
            } catch (IOException e) {
            }
		}
		for(int i = 1; i < pers.size(); i++) {
			Jugador porInsertar = (Jugador)pers.get(i);
			for(int j = i; j > 0; j--) {
				Jugador actual = (Jugador) pers.get(j-1);
				if(actual.compararPorPuntaje(porInsertar) > 0) {
					pers.set(j, actual);
					pers.set(j-1, porInsertar);
				}
			}
		}
		panPuntajes.refrescarLista(pers);
	}
	public void llamarBuscarPuntaje(int puntaje) {
		try {
			buscarPuntaje(puntaje);
		} catch (JugadorNoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void buscarPuntaje(int puntaje) throws JugadorNoExisteException{
		FileInputStream fileInStr = null;
		ObjectInputStream entrada = null;
		ArrayList<Jugador> pers = new ArrayList<Jugador>();
		try {
			fileInStr = new FileInputStream("archivos/jugadoresTotales.dat");
			entrada = new ObjectInputStream(fileInStr);
			while((ju = (Jugador) entrada.readObject()) != null) {
	        	if(!(ju.getNombre().equals(jugador.getNombre()))) {
	        		pers.add(ju);
	        	}
	        }
		} catch (Exception e) {
		} finally {
            try {
                if (fileInStr != null) {
                	fileInStr.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
            }
		}
		for(int i = 1; i < pers.size(); i++) {
			Jugador porInsertar = (Jugador)pers.get(i);
			for(int j = i; j > 0; j--) {
				Jugador actual = (Jugador) pers.get(j-1);
				if(actual.compararPorPuntaje(porInsertar) > 0) {
					pers.set(j, actual);
					pers.set(j-1, porInsertar);
				}
			}
		}
		String nombre = null;
		boolean encontre = false;
		int inicio = 0;
		int fin = pers.size() -1;
		while(inicio <= fin && !encontre) {
			int medio = (inicio + fin) / 2;
			if(pers.get(medio).getPuntaje() == puntaje) {
				encontre = true;
				nombre = pers.get(medio).getNombre();
			} else if(pers.get(medio).getPuntaje() > puntaje) {
				fin = medio - 1;
			} else {
				inicio = medio + 1;
			}
		}
		if(nombre == null) {
			throw new JugadorNoExisteException();
		} else {
			JOptionPane.showMessageDialog(null, "EL JUGADORES CON " + puntaje + " PUNTOS ES: " + nombre);
		}
	}
	/**
	 *	main
	 *	@param args
	 */
	public static void main(String[]args) {
		InterfazBuscandoDory i = new InterfazBuscandoDory();
		i.setVisible(true);
	}
}