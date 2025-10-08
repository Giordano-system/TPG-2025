package clases;

import interfaces.Interfaz_Especialidad;
import interfaces.Interfaz_Medico;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class DecoratorPosgrado implements  Interfaz_Medico ,Interfaz_Especialidad
{
	protected Interfaz_Especialidad encapsulado;

	public DecoratorPosgrado(Interfaz_Especialidad encapsulado)
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

    @Override
    public String toString(){
        return encapsulado.toString();
    }


}
