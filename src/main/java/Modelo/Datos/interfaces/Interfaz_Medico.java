package Modelo.Datos.interfaces;

import Modelo.Datos.clases.Consulta;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interfaz que define el comportamiento común de todos los médicos.
 * 
 * Toda clase que implemente esta interfaz debe tener un método para devolver la matricula, calcular el sueldo y un toString
 * @author Grupo 09 - POO
 * @version 1.0
 */
public interface Interfaz_Medico extends Interfaz_Persona 
{
	public int getMatricula();
	public double getSueldo();
	public String toString();
    public String getEspecialidad();
}
