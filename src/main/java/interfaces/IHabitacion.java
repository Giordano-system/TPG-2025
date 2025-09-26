package interfaces;

/**
 * Interfaz que define los métodos para una habitación.
 * Implementada por la clase Habitacion y sus subclases.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public interface IHabitacion {

    /**
     * Ocupa la habitación.
     */

    public void ocupar() throws HabitacionOcupadaException;

    /**
     * Desocupa la habitación.
     */

    public void desocupar();

    /**
     * Verifica si la habitación está ocupada.
     * @return true si la habitación está ocupada, false en caso contrario.
     */

    public boolean estaOcupada();

    /**
     * Devuelve el costo de la habitación por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0.
     */

    public double devolverCosto(int dias);

    /**
     * Devuelve el tipo de habitación.
     * @return String. Tipo de habitación.
     */

    public String getTipo();

}
