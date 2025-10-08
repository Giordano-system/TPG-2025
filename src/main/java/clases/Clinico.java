package clases;

import interfaces.Interfaz_Especialidad;

/**
 * Clase que representa a un médico clínico, que es un tipo de medico.
 * Hereda de la clase Medico e implementa la interfaz Interfaz_Especialidad.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Clinico extends Medico implements Interfaz_Especialidad
{

	public Clinico(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula)
	{
		super(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula, "Clínica");
	}

	@Override
	public double getSueldo()
	{
		return super.getSueldo()*1.05;
	}
}
