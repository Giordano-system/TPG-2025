package prueba;

import clases.*;
import interfaces.*;
import excepciones.*;

import java.time.LocalDate;

/**
 * Clase de prueba para el sistema de gestión de médicos.
 * @author Grupo 9 - POO
 * @version 1.0
 */

@SuppressWarnings("unused")
public class Prueba
{

	public static void main(String[] args)
	{
        Sistema sistema = new Sistema();
        Interfaz_Medico m = FactoryMedicos.getMedico("Magister", "Residente", "Clinica", "Juan", "Perez", "12345678", "Springfield", 1459, "223 596 4847", "Simpsons", 50000);
        System.out.println(m.getNombre());
        System.out.println(m.getEspecialidad());
        System.out.println(m.getSueldo());
        Consulta c = new Consulta("Carlos", LocalDate.of(2024, 6, 15), m.getSueldo());
        Consulta c2 = new Consulta("Agustin", LocalDate.of(2024, 9, 15), m.getSueldo());
        m.addConsultaMedica(c);
        m.addConsultaMedica(c2);
        m.reporteConsultas(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 9, 15));

	}

}
