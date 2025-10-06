package clases;

import interfaces.Interfaz_Especialidad;

import java.util.ArrayList;

/**
 * Clase que decora a un médico, le aumenta el sueldo un 5%.
 * Hereda de la clase DecoratorPosgrado.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class DecoratorPosgradoMagister extends DecoratorPosgrado
{

	public DecoratorPosgradoMagister(Interfaz_Especialidad encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getSueldo()
	{
		return this.encapsulado.getSueldo() * 1.05;
	}
	
	@Override
	public String getEspecialidad()
	{
		return encapsulado.getEspecialidad();
	}

}
