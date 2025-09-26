package clases;

import interfaces.Interfaz_Especialidad;

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
