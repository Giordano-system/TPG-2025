package clases;

/**
 * Clase que representa una habitación privada.
 * Hereda de la clase Habitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class HabitacionPrivada extends Habitacion {

    /**
     * Constructor de la clase HabitacionPrivada.
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     */

    public HabitacionPrivada(double costoFijo) {
        super(costoFijo);
    }

    /**
     * Ocupa la habitación privada.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si la habitacion esta desocupada.
     */

    @Override
    public void ocupar(){
        estaOcupado = true;
    }

    /**
     * Desocupa la habitación privada.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si la habitacion esta ocupada, desde el paciente que implementa a la instancia
     */

    @Override
    public void desocupar() {
        estaOcupado = false;
    }

    /**
     * Devuelve el costo de la habitación privada por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0.
     */

    @Override
    public double devolverCosto(int dias) {
        double costoTotal = 0;
        if (dias == 1) {
            costoTotal = costoFijo;
        } else if (dias>=2 && dias <=5) {
            costoTotal = costoFijo * 1.3 * dias;
        } else {
            costoTotal = costoFijo * 2 * dias;
        }
        return costoTotal + this.getCostoAsignacion();
    }

    /**
     * Devuelve el tipo de habitación.
     * @return String. Tipo de habitación.
     */

    @Override
    public String getTipo() {
        return "Habitacion Privada";
    }

}
