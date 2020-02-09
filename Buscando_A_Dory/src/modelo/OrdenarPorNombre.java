package modelo;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Jugador>{

	@Override
	public int compare(Jugador j, Jugador j1) {
		return j.getNombre().compareTo(j1.getNombre());
	}
	
}
