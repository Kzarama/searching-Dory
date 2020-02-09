package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Jugador;

class JugadorTest extends TestCase {
	Jugador j1,j;
	private void escenario1() {
		j = new Jugador("", 20, 2);
	}
	private void escenario2() {
		j = new Jugador("", 10, 1);
	}
	private void escenario3() {
		j = new Jugador("", 30, 2);
	}
	private void escenario4() {
		j = new Jugador("neuer", 30, 3);
	}
	private void escenario5() {
		j = new Jugador("neuer", 30, 3);
	}
	private void escenario6() {
		j = new Jugador("neuer", 30, 3);
	}
	@Test
	void testCompararPorPuntaje1() {
		escenario1();
		j1 = new Jugador("", 20, 2);
		assertEquals(j.compararPorPuntaje(j1), 0);
	}
	@Test
	void testCompararPorPuntaje2() {
		escenario2();
		j1 = new Jugador("", 20, 2);
		assertEquals(j.compararPorPuntaje(j1), -1);
	}
	@Test
	void testCompararPorPuntaje3() {
		escenario3();
		j1 = new Jugador("", 20, 2);
		assertEquals(j.compararPorPuntaje(j1), 1);
	}
	@Test
	void testGetNombre() {
		escenario4();
		assertEquals(j.getNombre() , "neuer");
	}
	@Test
	void testGetPUntaje() {
		escenario5();
		assertEquals(j.getPuntaje() , 30);
	}
	@Test
	void testGetNivel() {
		escenario6();
		assertEquals(j.getNivel() , 3);
	}
}