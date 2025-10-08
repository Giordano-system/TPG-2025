package excepciones;

import interfaces.Interfaz_Medico;

public class MedicoNoRegistradoException extends Exception {
    Interfaz_Medico medico;

    public MedicoNoRegistradoException(String message, Interfaz_Medico medico) {
        super(message);
        this.medico = medico;
    }

    public Interfaz_Medico getMedico() {
        return medico;
    }
}
