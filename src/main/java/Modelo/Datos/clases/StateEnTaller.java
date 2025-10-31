package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleExeption;

public class StateEnTaller implements StateAmbulancia {

    Ambulancia ambulancia;

    public StateEnTaller(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar traslado, realizando mantenimiento");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        //NADA
    }

    @Override
    public void SolicitudMantenimiento() {
        this.ambulancia.setEstado(new StateRegresandoTaller(this.ambulancia));
    }
}
