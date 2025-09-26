package clases;

import interfaces.Interfaz_Especialidad;

/**
 * Clase qeu decora a un médico, le aumenta el sueldo un 10%.
 * Hereda de la clase DecoratorPosgrado.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class DecoratorPosgradoDoctorado extends DecoratorPosgrado
{

	public DecoratorPosgradoDoctorado(Interfaz_Especialidad encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getSueldo()
	{
		return this.encapsulado.getSueldo() * 1.1;
	}

	@Override
	public String getEspecialidad()
	{
		return encapsulado.getEspecialidad();
	}
	
}
