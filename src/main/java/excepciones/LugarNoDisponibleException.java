package excepciones;

/**
 * Excepción que se lanza cuando no hay lugar disponible para internar a un paciente.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class LugarNoDisponibleException extends Exception {
    public LugarNoDisponibleException(String message) {
        super(message);
    }
}
