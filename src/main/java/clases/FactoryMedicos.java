package clases;

import interfaces.Interfaz_Medico;
/**
 * Clase que aplica el patron factory para la creacion de Medicos
 */
public class FactoryMedicos 
{
	/**
	 * Metodo que que devuelve el objeto medico correspondiente a los parametros
	 * <b>Pre: </b> todos los parametros deben ser distintos de null o vacio, y las modificaciones del medicio deben ser las correspondientes
	 * @param posgrado tipo de posgrado que tiene el medico
	 * @param contratacion tipo de contratacion que tiene el medico
	 * @param especialidad especialidad del medico
	 * @param nombre nombre del medico
	 * @param apellido apellido del medico
	 * @param dni DNI del medico
	 * @param calle calle del domicilio del medico
	 * @param numero altura de la calle del medico
	 * @param telefono telefono del medico
	 * @param ciudad ciudad donde vive el medico
	 * @param numMatricula numero de matricula del medico
	 * @return devuelve el objeto del medicco correspondiente
	 */

	public static Interfaz_Medico getMedico(String posgrado, String contratacion, String especialidad,
			String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula)
	{
		Interfaz_Medico resultado = null;
		if (contratacion.equalsIgnoreCase("PERMANENTE"))
		{
			if (posgrado.equalsIgnoreCase("MAGISTER"))
			{
				switch (especialidad.toLowerCase())
				{
					case "clinica": 
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoMagister(new Clinico(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "cirugia":
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoMagister(new Cirujano(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "pediatria":
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoMagister(new Pediatra(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
				}
			} else if (posgrado.equalsIgnoreCase("DOCTORADO"))
			{
				switch (especialidad.toLowerCase())
				{
					case "clinica": 
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoDoctorado(new Clinico(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "cirugia":
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoDoctorado(new Cirujano(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "pediatria":
						resultado = new DecoratorContratacionPermanente(new DecoratorPosgradoDoctorado(new Pediatra(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
				}
			}
		} else if (contratacion.equalsIgnoreCase("RESIDENTE"))
		{
			if (posgrado.equalsIgnoreCase("MAGISTER"))
			{
				switch (especialidad.toLowerCase())
				{
					case "clinica": 
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoMagister(new Clinico(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "cirugia":
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoMagister(new Cirujano(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "pediatria":
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoMagister(new Pediatra(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
				}
			} else if (posgrado.equalsIgnoreCase("DOCTORADO"))
			{
				switch (especialidad.toLowerCase())
				{
					case "clinica": 
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoDoctorado(new Clinico(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "cirugia":
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoDoctorado(new Cirujano(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
					case "pediatria":
						resultado = new DecoratorContratacionResidente(new DecoratorPosgradoDoctorado(new Pediatra(nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula)));
						break;
				}
			}
		}
		return resultado;
	}
}
