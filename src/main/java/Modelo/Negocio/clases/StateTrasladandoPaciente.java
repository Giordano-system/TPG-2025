package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleException;

public class StateTrasladandoPaciente implements StateAmbulancia{

    Ambulancia ambulancia;

    public StateTrasladandoPaciente(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio(){
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar traslado, realizando traslado");
    }

    @Override
    public void RetornoAutomaticoClinica() {
    	this.ambulancia.setEstado(new StateDisponible(this.ambulancia)); // Ver que hay que hacer en este caso
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar mantenimiento, realizando traslado");
    }
    
    @Override
	public String getNombre() {
		return "Trasladando paciente";
	}
}