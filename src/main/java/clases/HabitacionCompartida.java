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
    private final int costoHC = 500; // Costo adicional por asignacion de habitacion compartida

    /**
     * <b>Pre: </b> El costoFijo debe ser mayor a 0.
     * Constructor de la clase HabitacionCompartida.
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     * <b>Post: </b> Se crea una instancia de HabitacionCompartida con 0 camas ocupadas.
     */


    public HabitacionCompartida(double costoFijo) {
        super(costoFijo, "Habitacion Compartida");
        this.camasOcupadas = 0;
    }

    /**
     * <b>Pre: </b> La habitación debe tener al menos una cama libre para poder ocuparla.
     * Ocupa una cama en la habitación compartida.
     * Si todas las camas están ocupadas, se marca la habitación como ocupada.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si hay camas disponibles
     * <b>Post: </b> Se incrementa el contador de camas ocupadas. Si todas las camas están ocupadas, se marca la habitación como ocupada.
     */


    @Override
    public void ocupar() {
        camasOcupadas++;
        if (camasOcupadas == cantidadCamas) {
            estaOcupado = true;
        }
    }

    /**
     * <b>Pre: </b> La habitación debe tener al menos una cama ocupada para poder desocuparla.
     * Desocupa una cama en la habitación compartida.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si hay camas ocupadas, desde el paciente que implementa a la instancia de habitacion.
     * La habitacion siempre se va a marcar como desocupada al liberar una cama, ya que si se libera una cama, necesariamente hay al menos una cama libre.
     * <b>Post: </b> Se decrementa el contador de camas ocupadas. La habitación se marca como desocupada.
     */


    @Override
    public void desocupar() {
        camasOcupadas--;
        estaOcupado = false;
    }

    /**
     * <b>Pre: </b> Dias debe ser mayor a 0.
     * Devuelve el costo de la habitación compartida por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0.
     * <b>Post: </b> Se devuelve el costo total de la habitación por la cantidad de días.
     */


    @Override
    public double devolverCosto(int dias) {
        return costoHC * dias + this.getCostoAsignacion();
    }

    /**
     * Devuelve el tipo de habitación.
     * @return String. Tipo de habitación.
     */

    @Override
    public String getTipo() {
        return this.tipo;
    }

}
