package clases;

import interfaces.IPacientesComparables;
import java.util.ArrayList;

/**
 * Clase que representa a un paciente, que es una persona con un rango etario.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public abstract class Paciente extends Persona implements IPacientesComparables {
    private final String rangoEtario; // "Niño", "Joven", "Mayor"
    private final int numHistoriaClinica; // >0
    private ArrayList<Medico> consultasMedicas;
    private Habitacion habitacionInternacion;

    /**
     * Constructor de la clase Paciente.
     * @param nombre String!=""
     * @param apellido String!=""
     * @param calle String!=""
     * @param numero int>0
     * @param telefono String!=""
     * @param ciudad String!=""
     * @param rangoEtario String = "Nino", "Joven" o "Mayor"
     * @param numHistoriaClinica int>0
     */

    public Paciente(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, String rangoEtario, int numHistoriaClinica) {
        super(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.rangoEtario = rangoEtario;
        this.numHistoriaClinica = numHistoriaClinica;
        this.consultasMedicas = new ArrayList<Medico>();
        this.habitacionInternacion = null;
    }

    /**
     * Get del atributo rangoEtario.
     * @return Rango etario del paciente. String = "Niño", "Joven" o "Mayor"
     */
    public String getRangoEtario() {
        return rangoEtario;
    }

    /**
     * Get del atributo numHistoriaClinica.
     * @return Número de historia clínica del paciente. int>0
     */
    public int getNumHistoriaClinica() {
        return  numHistoriaClinica;
    }

    /**
     * Get del atributo consultasMedicas.
     * @return ArrayList de médicos que atendieron al paciente.
     */

    public ArrayList<Medico> getConsultasMedicas() {
        return consultasMedicas;
    }

    /**
     * Agrega un médico al ArrayList de consultas médicas del paciente.
     * @param medico Médico que atendió al paciente. Instancia de una subclase de Medico.
     */

    public void addConsultaMedica(Medico medico) {
        this.consultasMedicas.add(medico);
    }

    /**
     * Limpia el ArrayList de consultas médicas del paciente.
     */

    public void clearConsultasMedicas() {
        this.consultasMedicas.clear();
    }

    /**
     * Set del atributo habitacionInternacion.
     * @param habitacion Instancia de la habitación de internación del paciente. Habitacion != null
     */

    public void setHabitacionInternacion(Habitacion habitacion) {
        habitacion.ocupar();
        this.habitacionInternacion = habitacion;
    }

    /**
     * Get del atributo habitacionInternacion.
     * @return Instancia de la habitación de internación del paciente. Habitacion o null si no está internado.
     */

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
