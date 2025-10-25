package Modelo.Datos.clases;

/**
 * Clase que representa el modulo de internacion.
 * Permite internar pacientes en habitaciones.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class ModuloInterna {

    /**
     * <b>Pre: </b> La habitacion no debe estar ocupada y debe ser una instancia una subclase de Habitacion.
     * El parametro p debe ser una instancia de una subclase Paciente. <br>
     * @param p Paciente a internar.
     * @param h Habitacion donde se internara al paciente.
     * <b>Post: </b> El paciente queda internado en la habitacion pasada por parametro. El atributo Habitacion dentro de Paciente se setea con la habitacion pasada por parametro.
     * La habitacion queda ocupada. Se ocupara segun el tipo de habitacion que sea.
     */

    public void internaPaciente(Paciente p, Habitacion h){
        p.setHabitacionInternacion(h);
        h.ocupar();
    }

}
