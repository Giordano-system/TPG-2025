package Modelo.Datos.clases;

import Modelo.ModeloExcepciones.LugarNoDisponibleException;
import Modelo.ModeloExcepciones.NoExisteHabitacionException;

/**
 * Clase factory para crear instancias de diferentes tipos de habitaciones.
 * Utiliza el patrón de diseño Factory Method.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class factoryHabitaciones {

    /**
     * <b>Pre: </b>  El costoFijo debe ser mayor a 0.
     * Método estático que crea y devuelve una instancia de una subclase de Habitacion según el tipo especificado.
     * @param tipo Tipo de habitación. Puede ser "Sala de Internacion", "Habitacion Compartida" o "Habitacion Privada".
     * @param costoFijo Costo fijo de la habitación por día. double>0.
     * @return Una instancia de la subclase correspondiente de Habitacion, o null si el tipo no es válido.
     * <b>Post: </b> Se devuelve una instancia de la subclase correspondiente de Habitacion.
     */

    public static Habitacion factoryHabitaciones(String tipo, double costoFijo) throws NoExisteHabitacionException {
            String tipoLower = tipo.toLowerCase();
            Habitacion h;
            switch (tipoLower) {
                case "sala de internacion":
                    h = new SalaInternacion(costoFijo);
                    break;
                case "habitacion compartida":
                    h = new HabitacionCompartida(costoFijo);
                    break;
                case "habitacion privada":
                    h = new HabitacionPrivada(costoFijo);
                    break;
                default:
                    throw new NoExisteHabitacionException("No existe la habitacion del tipo: ", tipo);
            }
            return h;
    }
}
