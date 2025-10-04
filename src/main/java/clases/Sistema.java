package clases;

import excepciones.LugarNoDisponibleException;

import java.util.ArrayList;

/**
 * Clase que representa el sistema de gestión de pacientes y médicos.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public class Sistema {
    private final Sala sala;
    private final Patio patio;
    private final ArrayList<Paciente> lista_espera;
    private final ArrayList<Paciente> lista_atendidos;
    private final ArrayList<Medico> medicos;
    private final ArrayList<Habitacion> habitaciones;
    private final ModuloAtiende moduloAtiende;
    private final ModuloIngresa moduloIngresa;
    private final ModuloRegistra moduloRegistra;
    private final ModuloInterna moduloInterna;
    private final ModuloEgresa moduloEgresa;

    /**
     * Constructor de la clase Sistema.
     * <b>Post:</b> Se crea un objeto Sistema con sus atributos inicializados.
     */

    public Sistema() {
        this.sala = new Sala();
        this.patio = new Patio();
        this.lista_espera = new ArrayList<>();
        this.lista_atendidos = new ArrayList<>();
        this.medicos = new ArrayList<>();

        this.habitaciones = new ArrayList<>();
        cargarHabitaciones();
        this.moduloAtiende = new ModuloAtiende();
        this.moduloIngresa = new ModuloIngresa();
        this.moduloRegistra = new ModuloRegistra();
        this.moduloInterna = new ModuloInterna();
        this.moduloEgresa = new ModuloEgresa();
    }

    public Sala getSala() {
        return sala;
    }

    public Patio getPatio() {
        return patio;
    }

    public ArrayList<Paciente> getLista_espera() {
        return lista_espera;
    }

    public ArrayList<Paciente> getLista_atendidos() {
        return lista_atendidos;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void cargarHabitaciones(){
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
        this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
    }

    /**
     * Método para registrar un paciente en el sistema.
     * <b>Pre:</b> p es una instancia de paciente no nula.
     * @param p Paciente a registrar en el sistema.
     * <b>Post:</b> El paciente p es añadido a la lista de espera.
     */

    public void registraPaciente(Paciente p){
        this.moduloRegistra.registraPaciente(p, this.lista_espera);
    }

    /**
     * Método para ingresar un paciente al sistema.
     * <b>Pre:</b> p es una instancia de paciente no nula.
     * @param p Paciente que ingresa al sistema.
     * <b>Post:</b> El paciente p es ingresado en la sala si hay espacio, o tiene prioridad, de otra manera se ira a el patio.
     */

    public void ingresaPaciente(Paciente p){
        this.moduloIngresa.ingresaPaciente(this.sala, this.patio, p);
    }

    /**
     * Método para que un médico atienda a un paciente.
     * <b>Pre:</b> p es una instancia de paciente existente en la lista de espera o en la lista de atendidos, m es una instancia de médico existente en el array de médicos.
     * @param p Paciente a ser atendido.
     * @param m Médico que atiende al paciente. Existente en el array de medicos del sistema.
     * <b>Post:</b> El paciente p es atendido por el médico m. Si el paciente estaba en la sala, se elimina de la sala. Si estaba en el patio, se elimina del patio. Si el paciente no estaba en la lista de atendidos, se añade a dicha lista.
     */

    public void atiendoPaciente(Paciente p, Medico m){
        this.moduloAtiende.atiendoPaciente(p, m, this.lista_espera, this.lista_atendidos, this.patio, this.sala);
    }

    /**
     * Método para internar un paciente en una habitación disponible del tipo solicitado.
     * <b>Pre:</b> p != null, tipoHabitacion != null e tipoHabiacion== "Habitacion Compartida" o tipoHabitacion=="Habitacion Privada" o tipoHabitacion=="Sala de Internacion".
     * @param p Paciente a internar.
     * @param tipoHabitacion Tipo de habitación solicitada.
     * <b>Post:</b> El paciente queda internado en una habitación del tipo solicitado si hay disponibilidad. Si no fue posible internar al paciente, se lanza una excepción del tipo LugarNoDisponibleException.
     * @throws LugarNoDisponibleException Si no hay habitaciones disponibles del tipo solicitado.
     */

    public void internaPaciente(Paciente p, String tipoHabitacion) throws LugarNoDisponibleException {
        for(Habitacion h : this.habitaciones){
            if(h.getTipo().equals(tipoHabitacion) && !h.estaOcupada()){
                this.moduloInterna.internaPaciente(p, h);
                break;
            }
        }
        if (p.getHabitacionInternacion()==null)
            throw new LugarNoDisponibleException("No hay lugar disponible en el tipo de habitacion solicitado para internar al paciente.");
    }

    /**
     * Método para egresar a un paciente del sistema.
     * <b>Pre:</b> p es una instancia de paciente existente en la lista de atendidos.
     * @param p Paciente a egresar del sistema.
     * <b>Post:</b> El paciente p es egresado del sistema.
     * El paciente p ya no estará en la lista de atendidos.
     * Se generara una factura de egreso
     * @return Facturacion Objeto que contiene los detalles de la factura generada al egresar al paciente.
     */

    public Facturacion egresaPaciente(Paciente p) {
        return this.moduloEgresa.egresaPaciente(p, this.lista_atendidos);
    }

    /**
     * Método para egresar a un paciente del sistema y calcular el costo de su estadía.
     * <b>Pre:</b> p es una instancia de paciente existente en la lista de atendidos, dias>0.
     * El paciente p debe estar internado para poder calcular el costo de su estadía. Y su atributo habitacionInternacion no debe ser null.
     * <b>Post:</b> El paciente p es egresado del sistema.
     * El paciente p ya no estará en la lista de atendidos.
     * Se generara una factura de egreso con el costo de la estadía en la habitación.
     * La habitacion del paciente se desocupa, dependiendo del tipo que esta fuera.
     * @param p Paciente a egresar del sistema.
     * @param dias Cantidad de días que el paciente estuvo internado.
     * @return Facturacion Objeto que contiene los detalles de la factura generada al egresar al paciente.
     */

    public Facturacion egresaPaciente(Paciente p, int dias) {
        return this.moduloEgresa.egresaPaciente(p, this.lista_atendidos, dias);
    }

}
