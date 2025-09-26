package clases;

/**
 * Clase que representa una Sala.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Sala {

	private Paciente paciente;

	/**
     * Constructor de la clase Sala, empieza vacia.
     */
	
	public Sala() {
		super();
		this.paciente = null;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	/**
     * Método para agregar un paciente a la sala.
     * @param p Paciente a agregar a la sala.
     */
	public void agregaPaciente(Paciente p) {
		this.paciente = p;
	}

	/**
     * Método para eliminar el paciente de la sala.
     */
	public void eliminaPaciente() {
		this.paciente = null;
	}
}
