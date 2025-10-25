package Modelo.Datos.clases;

import java.util.ArrayList;

/**
 * Clase que representa un Patio.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class Patio {

	private ArrayList<Paciente> pacientes;

	/**
     * Constructor de la clase Patio, la lista de pacientes arranca vacia.
     */
	public Patio() {
		super();
		this.pacientes = new ArrayList<Paciente>();
	}
	
	/**
     * Método para agregar un paciente al patio.
     * <b>PRE:</b> pacientes != null, p != null.
     * @param p Paciente a agregar al patio.
     * <b>Post:</b> El patio queda con un nuevo paciente esperando.
     */
	public void agregaPaciente(Paciente p) {
		this.pacientes.add(p);
	}
	
	/**
     * Método para eliminar el paciente del patio.
     * <b>PRE:</b> pacientes != null, p != null.
     * @param p Paciente a eliminar de la lista de pacientes.
     * <b>Post:</b> El paciente ya no está más en el patio.
     */
	public void eliminaPaciente(Paciente p) {
		this.pacientes.remove(p);
	}

    /**
     * <b>Pre:</b> pacientes != null.
     * @return
     */

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
