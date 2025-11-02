package Modelo.Negocio.clases;

import Modelo.Datos.clases.Persona;

import java.util.Random;

public class Operario extends Persona {

    /**
     * Constructor de la clase Operario.
     * <b>Pre:</b> nombre!=null, nombre!="", apellido!=null, apellido!="", dni!=null, dni!="", calle!=null, calle!="", telefono!=null, telefono!="", ciudad!=null, ciudad!="", numero > 0.
     * @param nombre
     * @param apellido
     * @param dni
     * @param calle
     * @param numero
     * @param telefono
     * @param ciudad
     * <b>Post:</b> Se crea la instancia del Operario con los datos pasados como parametro.
     */

    public Operario(String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad) {
        super(nombre, apellido, dni, calle, numero, telefono, ciudad);
    }

}
