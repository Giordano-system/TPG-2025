package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleExeption;

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
    public void SolicitudTrasladoClinica() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar traslado, realizando traslado");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        //NADA
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar mantenimiento, realizando traslado");
    }
}