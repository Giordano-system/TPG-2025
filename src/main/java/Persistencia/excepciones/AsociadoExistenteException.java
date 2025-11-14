package Persistencia.excepciones;

import Modelo.Negocio.clases.Asociado;

public class AsociadoExistenteException extends Exception
{

	/**
	 *  Exception: Asociados ya existe en la BD
	 */
	private static final long serialVersionUID = 1L;
	
	private Asociado a;

	public AsociadoExistenteException(Asociado a)
	{
		super();
		this.a = a;
	}

	public Asociado getA()
	{
		return a;
	}
}
