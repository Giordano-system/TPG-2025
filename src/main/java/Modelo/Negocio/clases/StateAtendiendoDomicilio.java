package Modelo.Negocio.clases;

import Modelo.Negocio.interfaces.StateAmbulancia;
import Modelo.ModeloExcepciones.AccionImposibleException;

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
    public void SolicitudTrasladoClinica() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar traslado, atendiendo a domicilio");
    }

    @Override
    public void RetornoAutomaticoClinica() {
        this.ambulancia.setEstado(new StateRegresandoSinPaciente(this.ambulancia));
    }

    @Override
    public void SolicitudMantenimiento() throws AccionImposibleException {
        throw new AccionImposibleException("Imposible realizar mantenimiento, atendiendo a domicilio");
    }

	@Override
	public String getNombre() {
		return "Atendiendo a domicilio";
	}
}
