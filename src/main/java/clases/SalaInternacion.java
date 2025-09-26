package clases;


/**
 * Clase que representa una sala de internación.
 * Hereda de la clase Habitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class SalaInternacion extends Habitacion{

    /**
     * Constructor de la clase SalaInternacion.
     * @param costoFijo Costo fijo de la sala por día. double>0
     */

    public SalaInternacion(double costoFijo) {
        super(costoFijo);
    }

    /**
     * Ocupa la sala de internación.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si la sala esta desocupada.
     */

    @Override
    public void ocupar() {
        estaOcupado = true;
    }

    /**
     * Desocupa la sala de internación.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si la sala esta ocupada, desde el paciente que implementa a la instancia.
     */

    @Override
    public void desocupar() {
        estaOcupado = false;
    }

    /**
     * Devuelve el costo de la sala de internación por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0. Costo que aumenta de manera exponencial.
     */

    @Override
    public double devolverCosto(int dias) {
        return Math.pow(costoFijo,dias) + this.getCostoAsignacion();
    }

    /**
     * Devuelve el tipo de habitación.
     * @return String. Tipo de habitación.
     */

    @Override
    public String getTipo() {
        return "Sala de Internacion";
    }

}
