package clases;

/**
 * Clase que representa a un médico, que es una persona con un número de matrícula y una especialidad.
 * Hereda de la clase Persona.
 * @author Grupo 9 - POO
 * @version 1.0
 */


public abstract class Medico extends Persona{
    private final int numMatricula; // >0
    private String especialidad; // String = "Clinica", "Cirugia" o "Pediatria"

    /**
     * Constructor de la clase Medico.
     * @param nombre String!="".
     * @param apellido String!=""
     * @param dni String!="".
     * @param calle String!="".
     * @param numero int>0.
     * @param telefono String!="".
     * @param ciudad String!="".
     * @param numMatricula int>0.
     * @param especialidad String = "Clinica", "Cirugia" o "Pediatria".
     */

    public Medico(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula, String especialidad) {
        super.Persona(nombre, apellido, dni, calle, numero, telefono, ciudad);
        this.numMatricula = numMatricula;
        this.especialidad = especialidad;
    }

    /**
     * Get del atributo numMatricula.
     * @return Número de matrícula del médico. Int>0.
     */

    public int getNumMatricula() {
        return numMatricula;
    }

    /**
     * Get del atributo especialidad.
     * @return Especialidad del médico. String = "Clinica", "Cirugia" o "Pediatria".
     */

    public String getEspecialidad() {
        return especialidad;
    }



}
