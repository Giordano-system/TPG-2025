package Modelo.ModeloExcepciones;

import Modelo.Datos.clases.Paciente;

public class PacienteNoRegistradoException extends Exception {
    private Paciente p;


    public PacienteNoRegistradoException(String message, Paciente p) {
        super(message);
        this.p = p;
    }

    public Paciente getPaciente() {
        return p;
    }
}
