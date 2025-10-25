package Modelo.Datos.clases;

import Modelo.Datos.interfaces.Interfaz_Persona;

/**
 * Clase que representa a una persona con atributos como nombre, apellido, domicilio, teléfono y ciudad.
 * Contiene un constructor para inicializar estos atributos.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public abstract class Persona implements Interfaz_Persona {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected Domicilio domicilio;
    protected String telefono;
    protected String ciudad;

    /**
     * Constructor de la clase Persona.
     * <b>Pre: </b> Todos los parametros String deben ser String!="" y String != null y numero debe ser Int>0.
     * @param nombre String!=""
     * @param apellido String!=""
     * @param dni String!=""
     * @param calle String!=""
     * @param numero int>0
     * @param telefono String!=""
     * @param ciudad String!=""
     */

    public Persona(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = new Domicilio(calle, numero);
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    /**
     * Get del atributo nombre.
     * @return Nombre de la persona. String!=""
     */

    public String getNombre() {
        return this.nombre;
    }

    /**
     * Get del atributo apellido.
     * @return Apellido de la persona. String!=""
     */

    public String getApellido() {
        return this.apellido;
    }

    /**
     * Get del atributo dni.
     * @return DNI de la persona. String!=""
     */

    public String getDni() {
        return this.dni;
    }

    /**
     * Get del atributo domicilio.
     * @return Domicilio de la persona. Domicilio!=""
     */

    public Domicilio getDomicilio() {
        return this.domicilio;
    }

    /**
     * <b>Pre: </b> El domicilio no puede ser nulo. Calle debe ser String!="" y String != null y numero debe ser Int>0.
     * Set del atributo domicilio.
     * @param calle nombre de la calle del nuevo domicilio. String!=""
     * @param numero número de la calle del nuevo domicilio. Int>0
     */

    public void setDomicilio(String calle, int numero) {
        this.domicilio.setCalle(calle);
        this.domicilio.setNumero(numero);
    }

    /**
     * Get del atributo telefono.
     * @return Teléfono de la persona. String!=""
     */

    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Set del atributo telefono.
     * @param telefono nuevo teléfono de la persona. String!=""
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Get del atributo ciudad.
     * @return Ciudad de la persona. String!=""
     */

    public String getCiudad() {
        return this.ciudad;
    }





}
