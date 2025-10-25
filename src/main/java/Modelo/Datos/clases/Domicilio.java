package Modelo.Datos.clases;

/**
 * Clase que representa un domicilio con atributos como calle y número.
 * Contiene un constructor para inicializar estos atributos, así como métodos getter y setter para acceder y modificar los valores.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Domicilio {
    private String Calle;
    private int Numero;

    /**
     * <b>Pre: </b> El parametro calle debe ser String!="" && String!=null y numero debe ser Int>0. <br>
     * Constructor de la clase Domicilio.
     * @param calle nombre de la calle del domicilio. String != ""
     * @param numero número de la calle del domicilio. int > 0
     * <b>Post: </b> Se crea un objeto Domicilio con los valores pasados por parámetro.
     */

    public Domicilio(String calle, int numero) {
        Calle = calle;
        Numero = numero;
    }

    /**
     * Get del atributo Calle.
     * @return Calle del domicilio. String!=""
     */

    public String getCalle() {
        return Calle;
    }

    /**
     * Set del atributo Calle.
     * @param calle nombre de la calle del nuevo domicilio. String!=""
     */

    public void setCalle(String calle) {
        Calle = calle;
    }

    /**
     * Get del atributo Numero.
     * @return Numero del domicilio. int > 0
     */

    public int getNumero() {
        return Numero;
    }

    /**
     * Set del atributo Numero.
     * @param numero número de la calle del nuevo domicilio. Int > 0
     */

    public void setNumero(int numero) {
        Numero = numero;
    }

	@Override
	public String toString()
	{
		return "Domicilio [Calle=" + Calle + ", Numero=" + Numero + "]";
	}
    
    



}
