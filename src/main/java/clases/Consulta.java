package clases;
import java.time.LocalDate;

/**
 * Clase que representa una consulta médica.
 * Contiene atributos como el nombre del paciente, la fecha de la consulta y el honorario del médico.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Consulta {
    private final String nombrePaciente;
    private final LocalDate fechaConsulta;
    private final double HonorarioMedico;

    /**
     * Constructor de la clase Consulta.
     * <b>Pre:</b> nombrePaciente!=null, nombrePaciente!="", fechaConsulta!=null, honorarioMedico>=0
     * @param nombrePaciente Nombre del paciente
     * @param fechaConsulta Fecha de la consulta
     * @param honorarioMedico Honorario del médico por la consulta
     * <b>Post:</b> Se crea un objeto Consulta con los valores pasados por parámetro.
     */

    public Consulta(String nombrePaciente, LocalDate fechaConsulta, double honorarioMedico) {
        this.nombrePaciente = nombrePaciente;
        this.fechaConsulta = fechaConsulta;
        this.HonorarioMedico = honorarioMedico;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public double getHonorarioMedico() {
        return HonorarioMedico;
    }

    @Override
    public String toString() {
        return "Consulta: \n" + "Nombre Paciente: " + nombrePaciente + "Fecha Consulta: " + fechaConsulta + "Honorario Medico: " + HonorarioMedico + "\n";
    }

}
