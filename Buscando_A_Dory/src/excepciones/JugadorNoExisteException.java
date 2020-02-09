package excepciones;

public class JugadorNoExisteException extends Exception {
	public JugadorNoExisteException() {
		super("EL JUGADOR BUSCADO NO EXISTE");
	}
}
