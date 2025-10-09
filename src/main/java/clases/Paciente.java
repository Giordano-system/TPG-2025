package clases;

import interfaces.IPacientesComparables;
import interfaces.Interfaz_Medico;

import java.util.ArrayList;

/**
 * Clase que representa a un paciente, que es una persona con un rango etario.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public abstract class Paciente extends Persona implements IPacientesComparables {
    private final String rangoEtario; // "Niño", "Joven", "Mayor"
    private static int contadorPacientes = 0;
    private final int numHistoriaClinica; // >0
    private Habitacion habitacionInternacion;

    /**
     * Constructor de la clase Paciente.
     * <b>PRE:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", rangoEtario!=null, rangoEtario!="", numero>0, historiaClinica>0
     * @param nombre Nombre del paciente
     * @param apellido Apellido del paciente
     * @param calle Nombre de la calle (Domicilio)
     * @param numero Numero de la calle (Domicilio)
     * @param telefono Numero de telefono del paciente.
     * @param ciudad Ciudad del paciente.
     * @param rangoEtario Rango etario del paciente
     */

    public Paciente(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, String  rangoEtario) {
        super(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.rangoEtario = rangoEtario;
        this.numHistoriaClinica = ++contadorPacientes;
        this.habitacionInternacion = null;
    }

    public String getRangoEtario() {
        return rangoEtario;
    }

    public int getNumHistoriaClinica() {
        return  numHistoriaClinica;
    }



    public void setHabitacionInternacion(Habitacion habitacion) {
        habitacion.ocupar();
        this.habitacionInternacion = habitacion;
    }

    public Habitacion getHabitacionInternacion() {
        return this.habitacionInternacion;
    }

    /**
     * El paciente ya no va a tener una habitación de internación, debido a que este metodo solo es llamado en el egreso del paciente.
    */

    public void clearHabitacionInternacion() {
        this.habitacionInternacion = null;
    }
}
