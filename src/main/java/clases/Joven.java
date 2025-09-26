package clases;


/**
 * Clase que representa a un paciente mayor.
 * Hereda de la clase Paciente.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Joven extends Paciente {
	
	/**
     * Constructor de la clase Mayor.
     * @param nombre String!=""
     * @param apellido String!=""
     * @param calle String!=""
     * @param numero int>0
     * @param telefono String!=""
     * @param ciudad String!=""
     * @param rangoEtario String = "Nino", "Joven" o "Mayor"
     * @param numHistoriaClinica int>0
     */
	
	public Joven(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, String rangoEtario, int numHistoriaClinica) {
		super(nombre, apellido, dni, calle, numero, telefono, ciudad, rangoEtario, numHistoriaClinica);
	}
	
	/**
     * Compara dos pacientes por su rango etario.
     * @param p Paciente recien ingresado. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que llama al metodo, false en caso contrario.
     */
	@Override
	public boolean comparoPaciente(Paciente p) {
		return p.comparoNinos();
	}

	/**
     * Compara al joven (que ingresó) con un paciente mayor.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoMayores() {
		return false;
	}

	/**
     * Compara al joven (que ingresó) con un paciente joven.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoJovenes() {
		return true;
	}

	/**
     * Compara al joven (que ingresó) con un paciente niño.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoNinos() {
		return true;
	}
}
