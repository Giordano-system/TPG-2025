package excepciones;

public class PacienteNoAtendidoException extends Exception {
    private String nombre;
    private String apellido;
    private String dni;

    public PacienteNoAtendidoException(String message, String nombre, String apellido, String dni) {
        super(message);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }


}
