package Modelo.Datos.clases;

import Modelo.Datos.interfaces.Interfaz_Especialidad;

/**
 * Clase que representa a un pediatra, que es un tipo de medico.
 * Hereda de la clase Medico e implementa la interfaz Interfaz_Especialidad.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Pediatra extends Medico implements Interfaz_Especialidad
{

	public Pediatra(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula)
	{
		super(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula, "Pediatría");
	}

	@Override
	public double getSueldo()
	{
		return super.getSueldo()*1.07;
	}
}
