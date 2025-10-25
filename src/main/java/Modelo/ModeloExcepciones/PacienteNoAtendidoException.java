package Modelo.ModeloExcepciones;

import Modelo.Datos.clases.Paciente;

public class PacienteNoAtendidoException extends Exception {
    private Paciente p;

    public PacienteNoAtendidoException(String message, Paciente p) {
        super(message);
        this.p = p;
    }

    public Paciente getPaciente() {
        return p;
    }
}
