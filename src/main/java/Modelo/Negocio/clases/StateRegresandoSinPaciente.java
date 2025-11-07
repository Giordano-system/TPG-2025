package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleException;

public class StateRegresandoSinPaciente implements StateAmbulancia {

    Ambulancia ambulancia;

    public StateRegresandoSinPaciente(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        this.ambulancia.setEstado(new StateAtendiendoDomicilio(this.ambulancia));
    }

    @Override
    public void SolicitudTrasladoClinica() {
        this.ambulancia.setEstado(new StateTrasladandoPaciente(this.ambulancia));
    }

    @Override
    public void RetornoAutomaticoClinica() {
        this.ambulancia.setEstado(new StateDisponible(this.ambulancia));
    }

    @Override
    public void SolicitudMantenimiento() {
        this.ambulancia.setEstado(new StateEnTaller(this.ambulancia));
    }
    
    @Override
	public String getNombre() {
		return "Regresando sin paciente";
	}
}
