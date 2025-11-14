package Persistencia.excepciones;

import Modelo.Negocio.clases.Asociado;

public class AsociadoInexistenteException extends Exception
{

	/**
	 *   Exception: Asociados no existe en la BD
	 */
	private static final long serialVersionUID = 1L;
	
	private Asociado a;

	public AsociadoInexistenteException(Asociado a)
	{
		super();
		this.a = a;
	}

	public Asociado getA()
	{
		return a;
	}
}
