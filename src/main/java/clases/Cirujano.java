package clases;

import interfaces.Interfaz_Especialidad;


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
