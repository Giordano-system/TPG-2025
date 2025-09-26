package prueba;

import clases.Cirujano;
import clases.Clinico;
import clases.Pediatra;
import clases.DecoratorPosgrado;
import clases.DecoratorPosgradoDoctorado;
import clases.DecoratorPosgradoMagister;
import clases.DecoratorContratacion;
import clases.DecoratorContratacionPermanente;
import clases.DecoratorContratacionResidente;
import interfaces.Interfaz_Especialidad;
import interfaces.Interfaz_Medico;
import interfaces.Interfaz_Persona;
import interfaces.IPacientesComparables;

@SuppressWarnings("unused")
public class Prueba
{

	public static void main(String[] args)
	{
		Interfaz_Medico m1 = new DecoratorContratacionResidente(
								new DecoratorPosgradoMagister(
									new Clinico("Gian", "Distefano", "47256279", "Rojas", 6150, "2235376208", "Mar del Plata", 12959)));
		
		System.out.println(m1.getSueldo());
		System.out.println(m1);

	}

}
