package clases;

import interfaces.Interfaz_Medico;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que decora a un médico, le aumenta el sueldo un 5%.
 * Hereda de la clase DecoratorPosgrado.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public abstract class DecoratorContratacion implements Interfaz_Medico
{
	protected DecoratorPosgrado encapsulado;

	public DecoratorContratacion(DecoratorPosgrado encapsulado)
	{
		this.encapsulado = encapsulado;
	}

	@Override
	public String getNombre()
	{
		return this.encapsulado.getNombre();
	}

	@Override
	public String getApellido()
	{
		return this.encapsulado.getApellido();
	}

	@Override
	public String getDni()
	{
		return this.encapsulado.getDni();
	}

	@Override
	public Domicilio getDomicilio()
	{
		return this.encapsulado.getDomicilio();
	}

	@Override
	public String getTelefono()
	{
		return this.encapsulado.getTelefono();
	}

	@Override
	public String getCiudad()
	{
		return this.encapsulado.getCiudad();
	}

	@Override
	public int getMatricula()
	{
		return this.encapsulado.getMatricula();
	}

    @Override public String getEspecialidad() {
        return this.encapsulado.getEspecialidad();
    }

    @Override
    public String toString(){
        return encapsulado.toString();
    }


}
