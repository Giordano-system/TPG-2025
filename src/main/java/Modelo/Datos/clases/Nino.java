package Modelo.Datos.clases;


/**
 * Clase que representa a un paciente niño.
 * Hereda de la clase Paciente.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Nino extends Paciente {
	
	/**
     * Constructor de la clase niño.
     * <b>PRE:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", rangoEtario!=null, rangoEtario!="", numero>0, historiaClinica>0
     * @param nombre Nombre del paciente
     * @param apellido Apellido del paciente
     * @param calle Nombre de la calle (Domicilio)
     * @param numero Numero de la calle (Domicilio)
     * @param telefono Numero de telefono del paciente.
     * @param ciudad Ciudad del paciente.
     */
	
	public Nino(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad) {
		super(nombre, apellido, dni, calle, numero, telefono, ciudad, "Nino");
	}
	
	/**
     * Compara dos pacientes por su rango etario.
     * <b>Pre:</b> p!=null
     * @param p Paciente recien ingresado. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que llama al metodo, false en caso contrario.
     */
	@Override
	public boolean comparoPaciente(Paciente p) {
		return p.comparoNinos();
	}

	/**
     * Compara al niño (que ingresó) con un paciente mayor.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoMayores() {
		return true;
	}

	/**
     * Compara al niño (que ingresó) con un paciente joven.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoJovenes() {
		return false;
	}

	/**
     * Compara al niño (que ingresó) con un paciente niño.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */
	@Override
	public boolean comparoNinos() {
		return true;
	}
}
