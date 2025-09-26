package interfaces;

/**
 * Interfaz que define el comportamiento común de todos los médicos.
 * 
 * Toda clase que implemente esta interfaz debe tener un método para devolver la matricula, calcular el sueldo y un toString
 * @author Grupo 09 - POO
 * @version 1.0
 */
public interface Interfaz_Medico extends Interfaz_Persona 
{
	int getMatricula();
	double getSueldo();
	String toString();
}
