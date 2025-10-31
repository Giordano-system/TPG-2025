package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleExeption;

public class StateAtendiendoDomicilio implements StateAmbulancia {

    private Ambulancia ambulancia;

    public StateAtendiendoDomicilio(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    @Override
    public void SolicitudAtencionDomicilio() {
        //NADA
    }

    @Override
    public void SolicitudTrasladoClinica() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar traslado, atendiendo a domicilio");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        this.ambulancia.setEstado(new StateRegresandoSinPaciente(this.ambulancia));
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleExeption {
        throw new AccionImposibleExeption("Imposible realizar mantenimiento, atendiendo a domicilio");
    }

	@Override
	public String getNombre() {
		return "Atendiendo a domicilio";
	}
}
