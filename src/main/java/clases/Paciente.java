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

    public ArrayList<Medico> getConsultasMedicas() {
        return consultasMedicas;
    }

    public void addConsultaMedica(Medico medico) {
        this.consultasMedicas.add(medico);
    }

    public void clearConsultasMedicas() {
        this.consultasMedicas.clear();
    }

}
