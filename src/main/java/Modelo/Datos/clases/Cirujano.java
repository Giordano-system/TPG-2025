package Modelo.Datos.clases;

/**
 * Clase que representa a un cirujano, que es un tipo de medico.
 * Hereda de la clase Medico e implementa la interfaz Interfaz_Especialidad.
 * @author Grupo 9 - POO
 * @version 1.0
 */

import Modelo.Datos.interfaces.Interfaz_Especialidad;


public class Cirujano extends Medico implements Interfaz_Especialidad
{

	public Cirujano(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula)
	{
		super(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula, "Cirugía");
	}

	@Override
	public double getSueldo()
	{
		return super.getSueldo()*1.1;
	}
}
