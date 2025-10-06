package clases;


/**
 * Clase que representa una sala de internación.
 * Hereda de la clase Habitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class SalaInternacion extends Habitacion{

    private final int costoSI = 2000;

    /**
     * <b>Pre: </b> El costoFijo debe ser mayor a 0.
     * Constructor de la clase SalaInternacion.
     * @param costoFijo Costo fijo de la sala por día. double>0
     * <b>Post: </b> Se crea una instancia de SalaInternacion.
     */

    public SalaInternacion(double costoFijo) {
        super(costoFijo, "Sala de Internacion");
    }

    /**
     * <b>Pre: </b> La sala debe estar desocupada para poder ocuparla.
     * Ocupa la sala de internación.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si la sala esta desocupada.
     * <b>Post: </b> Se marca la sala como ocupada.
     */

    @Override
    public void ocupar() {
        estaOcupado = true;
    }

    /**
     * <b>Pre: </b> La sala debe estar ocupada para poder desocuparla.
     * Desocupa la sala de internación.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si la sala esta ocupada, desde el paciente que implementa a la instancia.
     * <b>Post: </b> Se marca la sala como desocupada.
     */

    @Override
    public void desocupar() {
        estaOcupado = false;
    }

    /**
     * <b>Pre: </b> Dias debe ser mayor a 0.
     * Devuelve el costo de la sala de internación por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0. Costo que aumenta de manera exponencial.
     * <Post: </b> Se devuelve el costo total de la habitación por la cantidad de días.
     */

    @Override
    public double devolverCosto(int dias) {
        return Math.pow(costoSI,dias) + this.getCostoAsignacion();
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
