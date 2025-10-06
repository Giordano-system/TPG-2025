package clases;

/**
 * Clase que representa una habitación privada.
 * Hereda de la clase Habitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class HabitacionPrivada extends Habitacion {
    private final int costoHP = 1000;

    /**
     * <b>Pre: </b> El costoFijo debe ser mayor a 0.
     * Constructor de la clase HabitacionPrivada.
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     * <b>Post: </b> Se crea una instancia de HabitacionPrivada.
     */

    public HabitacionPrivada(double costoFijo) {
        super(costoFijo, "Habitacion Privada");
    }

    /**
     * <b>Pre: </b> La habitación debe estar desocupada para poder ocuparla.
     * Ocupa la habitación privada.
     * No se verifica que ya este ocupada ya que se asume que se llama este metodo solo si la habitacion esta desocupada.
     * <b>Post: </b> Se marca la habitación como ocupada.
     */


    @Override
    public void ocupar(){
        estaOcupado = true;
    }

    /**
     * <b>Pre: </b> La habitación debe estar ocupada para poder desocuparla.
     * Desocupa la habitación privada.
     * No se verifica que ya este desocupada ya que se asume que se llama este metodo solo si la habitacion esta ocupada, desde el paciente que implementa a la instancia
     * <b>Post: </b> Se marca la habitación como desocupada.
     */


    @Override
    public void desocupar() {
        estaOcupado = false;
    }

    /**
     * <b>Pre: </b> Dias debe ser mayor a 0.
     * Devuelve el costo de la habitación privada por una cantidad de días.
     * @param dias Cantidad de días que se va a ocupar la habitación. int>0.
     * @return Costo total de la habitación por la cantidad de días. double>0.
     * <Post: </b> Se devuelve el costo total de la habitación por la cantidad de días.
     */

    @Override
    public double devolverCosto(int dias) {
        double costoTotal = 0;
        if (dias == 1) {
            costoTotal = costoHP;
        } else if (dias>=2 && dias <=5) {
            costoTotal = costoHP * 1.3 * dias;
        } else {
            costoTotal = costoHP * 2 * dias;
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
