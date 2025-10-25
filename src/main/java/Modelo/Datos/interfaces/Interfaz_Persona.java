package Modelo.Datos.interfaces;

import Modelo.Datos.clases.Domicilio;

/**
 * Interfaz que define el comportamiento común de todos las personas.
 * 
 * Toda clase que implemente esta interfaz debe tener un método para devolver los atributos de una Persona
 */
public interface Interfaz_Persona
{	
    String getNombre();
    String getApellido();
    String getDni();
    Domicilio getDomicilio();
    String getTelefono();
    String getCiudad();
}
