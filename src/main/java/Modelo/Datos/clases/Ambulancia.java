package Modelo.Datos.clases;

import Modelo.Datos.interfaces.StateAmbulancia;

public class Ambulancia {

    private StateAmbulancia estado;

    public Ambulancia() {
        this.estado = new StateDisponible(this);
    }

    public StateAmbulancia getEstado() {
        return this.estado;
    }

    public void setEstado(StateAmbulancia estado) {
        this.estado = estado;
    }
}
