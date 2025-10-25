package Modelo.Datos.clases;

/**
 * Clase que decora a un médico, le aumenta el sueldo un 10%.
 * Hereda de la clase DecoratorContratacion.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class DecoratorContratacionPermanente extends DecoratorContratacion
{

	public DecoratorContratacionPermanente(DecoratorPosgrado encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getSueldo()
	{
		return this.encapsulado.getSueldo() * 1.1;
	}
	
	@Override
	public String toString()
	{
		return "Nombre Médico: " + encapsulado.getApellido() + " " + this.getNombre() + " Especialidad: " + encapsulado.getEspecialidad();
	}

}
