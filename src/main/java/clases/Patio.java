package clases;

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
     * @param p Paciente a agregar al patio.
     */
	public void agregaPaciente(Paciente p) {
		this.pacientes.add(p);
	}
	
	/**
     * Método para eliminar el paciente del patio.
     * @param p Paciente a eliminar de la lista de pacientes.
     */
	public void eliminaPaciente(Paciente p) {
		this.pacientes.remove(p);
	}
}
