package Modelo.Datos.clases;

/**
 * Clase que representa a un Asociado.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class Asociado extends Persona {
	
	private int solicitudes;

	/**
     * Constructor de la clase Asociado.
     * <b>PRE:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", numero > 0, solicitudes > 0
     * @param nombre Nombre del asociado.
     * @param apellido Apellido del asociado.
     * @param dni Documento del asociado.
     * @param calle Nombre de la calle (Domicilio)
     * @param numero Numero de la calle (Domicilio)
     * @param telefono Numero de telefono del asociado.
     * @param ciudad Ciudad del asociado.
     * @param solicitudes Cantidad de solicitudes del asociado a la ambulancia.
     */
	public Asociado(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int solicitudes) {
		super(nombre, apellido, dni, calle, numero, telefono, ciudad);
		this.solicitudes = solicitudes;
	}

	public int getSolicitudes() {
		return solicitudes;
	}
}
