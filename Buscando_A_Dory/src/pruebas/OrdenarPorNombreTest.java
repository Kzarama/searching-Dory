package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfaz.PanelPuntajes;
import junit.framework.TestCase;
import modelo.Jugador;
import modelo.OrdenarPorNombre;

class OrdenarPorNombreTest extends TestCase {
	Jugador j, j1;
	OrdenarPorNombre o;
	private void escenario1() {
		j = new Jugador("marco", 10, 1);
		o = new OrdenarPorNombre();
	}
	private void escenario2() {
		j = new Jugador("ronaldo", 10, 1);
		o = new OrdenarPorNombre();
	}
	private void escenario3() {
		j = new Jugador("iker", 10, 1);
		o = new OrdenarPorNombre();
	}
	@Test
	void testCompararPorNombre1() {
		escenario1();
		j1 = new Jugador("reus", 20, 2);
		assertEquals(o.compare(j, j1), -5);
	}
	@Test
	void testCompararPorNombre2() {
		escenario2();
		j1 = new Jugador("cristiano", 20, 2);
		assertEquals(o.compare(j, j1), 15);
	}
	@Test
	void testCompararPorNombre3() {
		escenario3();
		j1 = new Jugador("iker", 20, 2);
		assertEquals(o.compare(j, j1), 0);
	}
}