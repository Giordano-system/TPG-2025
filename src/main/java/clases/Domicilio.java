package clases;

public class Domicilio {
    private String Calle;
    private int Numero;

    /**
     * Constructor de la clase Domicilio.
     * @param calle nombre de la calle del domicilio. String != ""
     * @param numero número de la calle del domicilio. int > 0
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



}
