package excepciones;

public class NoExisteHabitacionException extends Exception {
    private String tipoSolicitado;

    public NoExisteHabitacionException(String message, String tipo) {
        super(message);
        this.tipoSolicitado = tipo;
    }

    public String getTipoSolicitado() {
        return tipoSolicitado;
    }

}
