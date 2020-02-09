package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class Jugador implements Serializable {
	/**
	 *	atributos de la clase Jugador
	 */
	private String nombre;
	private int puntaje, nivel;
	/**
	 *	constructor de la clase Jugados
	 *	@param nombre
	 *	@param puntaje
	 *	@param nivel
	 */
	public Jugador(String nombre, int puntaje, int nivel) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.nivel = nivel;
	}
	/**
	 *	getNombre
	 *	@return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *	setNombre
	 *	@param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 *	getPuntaje
	 *	@return puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 *	setPuntaje
	 *	@param puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	/**
	 *	getNivel
	 *	@return nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 *	setNivel
	 *	@param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 *	mostrarPuntajes
	 *	@return puntajes
	 */
	public String mostrarPuntajes() {
		File file = new File("archivos/puntajes.txt");
		String puntajes = "";
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String punta = "NOMBRE: " + nombre + "\n" + "PUNTAJE: " + puntaje + "\n" + "NIVEL: " + nivel;
			bw.write(punta);
			bw.close();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null) {
				puntajes += line + "\n";
			}
			br.close();
		} catch (Exception e) {
		}
		return puntajes;
	}
	public int compararPorPuntaje(Jugador j) {
		int num = 0;
		if(puntaje < j.getPuntaje() && nivel <= j.nivel) {
			num = -1;
		} else if(puntaje > j.getPuntaje() && nivel >= j.nivel) {
			num = 1;
		}
		return num;
	}
	public String toString() {
		return "NOMBRE: "+nombre+" puntaje: "+puntaje+" nivel: "+nivel;
	}
}