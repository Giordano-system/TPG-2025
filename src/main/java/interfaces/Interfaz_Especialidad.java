package interfaces;

/**
 * Interfaz que define el comportamiento común de todas las especialidades.
 * 
 * Toda clase que implemente esta interfaz debe tener un método para devolver la especialidad y calcular el sueldo
 * @author Grupo 09 - POO
 * @version 1.0
 */

public interface Interfaz_Especialidad extends Interfaz_Medico
{
	double getSueldo();
	String getEspecialidad();
}
