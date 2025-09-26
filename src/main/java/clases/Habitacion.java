package clases;

import interfaces.IHabitacion;

/**
 * Clase abstracta que representa una habitación.
 * Implementa la interfaz IHabitacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public abstract class Habitacion implements IHabitacion {
    protected boolean estaOcupado;
    protected double costoFijo;
    private static double costoAsignacion = 1000; // Costo fijo de asignación de habitación.

    /**
     * Constructor de la clase Habitacion.
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     */

    public Habitacion(double costoFijo) {
        this.costoFijo = costoFijo;
        this.estaOcupado = false;
    }

    /**
     * Metodo que indica si la habitacion esta ocupada.
     * @return boolean. Retorna true si esta ocupada, false en caso contrario.
     */


    public boolean estaOcupada() {
            return estaOcupado;
    }

    /**
     * Metodo que setea el costo de asignacion de habitacion.
     * @param costo Costo de asignacion. double>0.
     */

    public void setCostoAsignacion(double costo){
        this.costoAsignacion = costo;
    }

    /**
     * Metodo que devuelve el costo de asignacion de habitacion.
     * @return double. Retorna el costo de asignacion.
     */

    public double getCostoAsignacion(){
        return costoAsignacion;
    }


}
