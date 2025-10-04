package clases;

import interfaces.Interfaz_Medico;

/**
 * Clase que representa a un médico, que es una persona con un número de matrícula y una especialidad.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */


public abstract class Medico extends Persona implements Interfaz_Medico{
    private final int numMatricula; // >0
    private String especialidad; // Clinica, Cirugia o Pediatria
    private static double sueldo = 20000;

    /**
     * <b>Pre: </b> Todos los parametros String deben ser String!="" y String != null, numero debe ser Int>0 y especialidad debe ser Clinica, Cirugia o Pediatria.
     * Constructor de la clase Medico.
     * @param nombre String!="".
     * @param apellido String!=""
     * @param dni String!="".
     * @param calle String!="".
     * @param numero int>0.
     * @param telefono String!="".
     * @param ciudad String!="".
     * @param numMatricula int>0.
     * @param especialidad == Clinica || especialidad == Cirugia || especialidad == Pediatria
     */
    public Medico(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula, String especialidad) {
        super(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.numMatricula = numMatricula;
        this.especialidad = especialidad;
    }

    /**
     * Get del atributo numMatricula.
     * @return Número de matrícula del médico. Int>0.
     */
	@Override
	public int getMatricula()
	{
		return this.numMatricula;
	}
	
	
	/**
	 * Get del atributo especialidad
	 * @return Tipo de especialidad del médico
	 */
	public String getEspecialidad()
	{
		return this.especialidad;
	}

	/**
	 * Get del atributo sueldo
	 * @return sueldo base de todos los médicos
	 */
	@Override
	public double getSueldo()
	{
		return sueldo;
	}
}
