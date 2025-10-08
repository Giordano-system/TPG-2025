package clases;

import java.time.LocalDate;

public class ConsultasHistoricas {
    private String nombreMedico;
    private String especialidad;
    private Double honorarioTotal;
    private LocalDate fechaConsulta;

    /**
     * Constructor de la clase ConsultasHistoricas.
     * <b>Pre:</b> nombreMedico != null && nombreMedico !="", especialidad != null && especialidad !="", honorarioTotal >= 0, fechaConsulta != null.
     *
     */

    public ConsultasHistoricas(String nombreMedico, String especialidad, Double honorarioTotal, LocalDate fechaConsulta) {
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.honorarioTotal = honorarioTotal;
        this.fechaConsulta = fechaConsulta;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Double getHonorarioTotal() {
        return honorarioTotal;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    @Override
    public String toString() {
        return ("\nNombre Medico: " + nombreMedico + " Especialidad: " + especialidad + " Subtotal: " + honorarioTotal);
    }

}
