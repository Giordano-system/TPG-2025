package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleExeption;

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
    public void SolicitudMantenimiento() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar mantenimiento, regresando sin paciente");
    }
    
    @Override
	public String getNombre() {
		return "Regresando sin paciente";
	}
}
