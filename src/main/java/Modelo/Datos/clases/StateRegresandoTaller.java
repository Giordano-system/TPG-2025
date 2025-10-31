package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleExeption;

public class StateRegresandoTaller implements StateAmbulancia {

    Ambulancia ambulancia;

    public StateRegresandoTaller(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar traslado a clinica, regresando de mantenimiento");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        this.ambulancia.setEstado(new StateDisponible(this.ambulancia));
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar mantenimiento, regresando de mantenimiento");
    }
    
    @Override
	public String getNombre() {
		return "Regresando del taller";
	}
}
