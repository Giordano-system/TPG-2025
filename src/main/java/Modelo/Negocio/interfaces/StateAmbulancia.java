package Modelo.Negocio.interfaces;

public interface StateAmbulancia {

    /**
     * Solicita atencion a domicilio.
     */
    public void SolicitudAtencionDomicilio();

    /**
     * Solicita busqueda en domicilio y traslado posterior a clinica.
     */
    public void SolicitudTrasladoClinica();

    /**
     * Retorno automatico a clinica pasado cumplidas condiciones.
     */
    public void RetornoAutomaticoClinica();

    /**
     * Solicita y posteriormente traslada a taller para mantenimiento.
     */
    public void SolicitudMantenimiento();
    
    /**
     * Retorna el nombre del estado actual de la ambulancia.
     */
    public String getNombre();
}
