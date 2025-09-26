package clases;

/**
 * Clase que representa una habitación compartida.
 * Hereda de la clase Habitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class HabitacionCompartida extends Habitacion {
    private static final int cantidadCamas = 2;
    private int camasOcupadas; // >=0 && <= cantidadCamas

    /**
     * Constructor de la clase HabitacionCompartida.
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     */

    public HabitacionCompartida(double costoFijo) {
        super(costoFijo);
        this.camasOcupadas = 0;
    }

    /**
     * Ocupa una cama en la habitación compartida.
     * Si todas las camas están ocupadas, se marca la habitación como ocupada.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si hay camas disponibles
     */

    @Override
    public void ocupar() {
        camasOcupadas++;
        if (camasOcupadas == cantidadCamas) {
            estaOcupado = true;
        }
    }

    /**
     * Desocupa una cama en la habitación compartida.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si hay camas ocupadas, desde el paciente que implementa a la instancia de habitacion.
     * La habitacion siempre se va a marcar como desocupada al liberar una cama, ya que si se libera una cama, necesariamente hay al menos una cama libre.
     */

    @Override
    public void desocupar() {
        camasOcupadas--;
        estaOcupado = false;
    }

    /**
     * Devuelve el costo de la habitación compartida por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0.
     */

    @Override
    public double devolverCosto(int dias) {
        return costoFijo * dias + this.getCostoAsignacion();
    }

    /**
     * Devuelve el tipo de habitación.
     * @return String. Tipo de habitación.
     */

    @Override
    public String getTipo() {
        return "Habitacion Compartida";
    }

}
