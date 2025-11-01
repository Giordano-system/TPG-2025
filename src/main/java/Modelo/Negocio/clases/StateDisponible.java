package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;

public class StateDisponible implements StateAmbulancia {

    private Ambulancia ambulancia;

    public StateDisponible(Ambulancia ambulancia) {
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
        //NADA
    }

    @Override
    public void SolicitudMantenimiento() {
        this.ambulancia.setEstado(new StateEnTaller(this.ambulancia));
    }
    
    @Override
	public String getNombre() {
		return "Disponible";
	}
}
