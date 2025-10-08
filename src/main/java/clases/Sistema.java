package clases;


import interfaces.Interfaz_Especialidad;
import interfaces.Interfaz_Medico;
import excepciones.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

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
    private final HashMap<Integer, ArrayList<ConsultasHistoricas>> historialConsultas;
    private final ArrayList<Interfaz_Medico> medicos;
    private final HashMap<Integer, ArrayList<Consulta>> consultasMedicas;
    private final ArrayList<Habitacion> habitaciones;
    private final ModuloAtiende moduloAtiende;
    private final ModuloRegistros moduloRegistros;
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
        cargarMedicos();
        this.habitaciones = new ArrayList<>();
        cargarHabitaciones();
        this.historialConsultas = new HashMap<>();
        this.consultasMedicas = new HashMap<>();
        this.moduloAtiende = new ModuloAtiende();
        this.moduloIngresa = new ModuloIngresa();
        this.moduloRegistra = new ModuloRegistra();
        this.moduloRegistros = new ModuloRegistros();
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

    public ArrayList<Interfaz_Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    //Se crean varios medicos de cada tipo donde el posgrado puede ser Magister o Doctorado, la contratacion Permanente o Residente y la especialidad puede ser Cirugia, Pediatria o Clinica.

    public void cargarMedicos(){
        this.medicos.add(FactoryMedicos.getMedico("Magister", "Permanente", "Cirugia", "Juan", "Aldana", "45789632", "Los Troncos", 1450, "2237894564", "Mar del Plata", 1234));
        this.medicos.add(FactoryMedicos.getMedico("Doctorado", "Permanente", "Pediatria", "Ana", "Lopez", "40123658", "Las Heras", 2345, "2234567890", "Mar del Plata", 5678));
        this.medicos.add(FactoryMedicos.getMedico("Magister", "Residente", "Clinica", "Luis", "Garcia", "38965412", "San Martin", 678, "2231234567", "Mar del Plata", 9101));
        this.medicos.add(FactoryMedicos.getMedico("Magister", "Permanente", "Cirugia", "Valentino", "Giordano", "46632600", "España", 1459, "2235964847", "Mar del Plata", 2214));
        this.medicos.add(FactoryMedicos.getMedico("Doctorado", "Permanente", "Pediatria", "Micaela", "Fernandez", "40123659", "La Rioja", 2346, "2234567891", "Mar del Plata", 5679));
        this.medicos.add(FactoryMedicos.getMedico("Magister", "Residente", "Clinica", "Sofia", "Martinez", "38965413", "San Luis", 679, "2231234568", "Mar del Plata", 9102));
        this.medicos.add(FactoryMedicos.getMedico("Magister", "Permanente", "Cirugia", "Mateo", "Rodriguez", "45789633", "Mitre", 1451, "2237894565", "Mar del Plata", 1235));
        for (Interfaz_Medico m : this.medicos){
            this.moduloRegistros.addMedico(m, this.consultasMedicas);
        }
    }

    /**
     * Metodo que que devuelve el objeto medico correspondiente a los parametros
     * <b>Pre: </b> todos los parametros deben ser distintos de null o vacio, y las modificaciones del medicio deben ser las correspondientes
     * @param posgrado tipo de posgrado que tiene el medico
     * @param contratacion tipo de contratacion que tiene el medico
     * @param especialidad especialidad del medico
     * @param nombre nombre del medico
     * @param apellido apellido del medico
     * @param dni DNI del medico
     * @param calle calle del domicilio del medico
     * @param numero altura de la calle del medico
     * @param telefono telefono del medico
     * @param ciudad ciudad donde vive el medico
     * @param numMatricula numero de matricula del medico
     * <b>Post: </b> Se añade un intefaz_medico con las modificaciones correspondientes a su posgrado y tipo de contratacion a la lista de medicos del sistema.
     */

    public void addMedico(String posgrado, String contratacion, String especialidad, String nombre, String apellido, String dni, String calle, int numero, String telefono, String ciudad, int numMatricula){
        Interfaz_Medico nuevoMedico = FactoryMedicos.getMedico(posgrado, contratacion, especialidad, nombre, apellido, dni, calle, numero, telefono, ciudad, numMatricula);
        if (nuevoMedico != null) {
            this.medicos.add(nuevoMedico);
            this.moduloRegistros.addMedico(nuevoMedico, this.consultasMedicas);
        } else {
            System.out.println("No se pudo crear el medico con los datos proporcionados.");
        }
    }

    public void cargarHabitaciones(){
        try{
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Compartida", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Habitacion Privada", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones("Sala de Internacion", 500));
        } catch (NoExisteHabitacionException e){
            System.out.println(e.getMessage() + e.getTipoSolicitado());
        }
    }

    public void addHabitacion(String tipo){
        try{
            this.habitaciones.add(factoryHabitaciones.factoryHabitaciones(tipo, 500));
        } catch (NoExisteHabitacionException e){
            System.out.println(e.getMessage() + e.getTipoSolicitado());
        }
    }

    /**
     * Método para registrar un paciente en el sistema.
     * <b>Pre:</b> p es una instancia de paciente no nula.
     * @param p Paciente a registrar en el sistema.
     * <b>Post:</b> El paciente p es añadido a la lista de espera.
     */

    public void registraPaciente(Paciente p){
        this.moduloRegistra.registraPaciente(p, this.lista_espera);
        this.moduloRegistros.addPaciente(p, this.historialConsultas);
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

    public void atiendoPaciente(Paciente p, Interfaz_Medico m) throws PacienteNoRegistradoException, MedicoNoRegistradoException {
        this.moduloAtiende.atiendoPaciente(p, m, this.medicos ,this.lista_espera, this.lista_atendidos, this.patio, this.sala);
        this.moduloRegistros.registrarConsultaPaciente(p, m, this.historialConsultas);
        this.moduloRegistros.registrarConsultaMedico(p, m, this.consultasMedicas);
    }

    /**
     * Método para internar un paciente en una habitación disponible del tipo solicitado.
     * <b>Pre:</b> p != null, tipoHabitacion != null.
     * @param p Paciente a internar.
     * @param tipoHabitacion Tipo de habitación solicitada.
     * <b>Post:</b> El paciente queda internado en una habitación del tipo solicitado si hay disponibilidad. Si no fue posible internar al paciente, se lanza una excepción del tipo LugarNoDisponibleException.
     * @throws LugarNoDisponibleException Si no hay habitaciones disponibles del tipo solicitado.
     */

    public void internaPaciente(Paciente p, String tipoHabitacion) throws LugarNoDisponibleException, NoExisteHabitacionException, PacienteNoRegistradoException {
        if (!(this.lista_atendidos.contains(p) || this.lista_espera.contains(p))){
            throw new PacienteNoRegistradoException("El paciente no ha sido registrado, no puede ser internado.",p);
        } else {
            if (!tipoHabitacion.equals("Sala de Internacion") && !tipoHabitacion.equals("Habitacion Compartida") && !tipoHabitacion.equals("Habitacion Privada")){
                throw new NoExisteHabitacionException("No existe la habitacion del tipo: ", tipoHabitacion);
            } else {
                for(Habitacion h : this.habitaciones){
                    if(h.getTipo().equals(tipoHabitacion) && !h.estaOcupada()){
                        this.moduloInterna.internaPaciente(p, h);
                        break;
                    }
                }
                if (p.getHabitacionInternacion()==null)
                    throw new LugarNoDisponibleException("No hay lugar disponible en el tipo de habitacion solicitado para internar al paciente.");
            }
        }

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

    public Facturacion egresaPaciente(Paciente p) throws PacienteNoAtendidoException, PacienteNoRegistradoException {
        LocalDate fechaActual = LocalDate.now();
        ArrayList<ConsultasHistoricas>consultasTotales = this.historialConsultas.get(p.getNumHistoriaClinica());
        ArrayList<ConsultasHistoricas> consultasActuales = new ArrayList<>();
        if (consultasTotales != null) {
            for (ConsultasHistoricas ch : consultasTotales) {
                if (ch.getFechaConsulta().getMonth() == fechaActual.getMonth() && ch.getFechaConsulta().getYear() == fechaActual.getYear() && ch.getFechaConsulta().isBefore(fechaActual) || ch.getFechaConsulta().isEqual(fechaActual)) {
                    consultasActuales.add(ch);
                }
            }
            return this.moduloEgresa.egresaPaciente(p, consultasActuales, this.lista_atendidos);
        } else {
            throw new PacienteNoRegistradoException("El paciente no esta registrado en el sistema, no puede egresar.", p);
        }
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

    public Facturacion egresaPaciente(Paciente p, int dias) throws PacienteNoAtendidoException, PacienteNoRegistradoException{
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngreso = LocalDate.now().minusDays(dias);
        ArrayList<ConsultasHistoricas>consultasTotales = this.historialConsultas.get(p.getNumHistoriaClinica());
        ArrayList<ConsultasHistoricas> consultasActuales = new ArrayList<>();
        if (consultasTotales != null) {
            for (ConsultasHistoricas ch : consultasTotales) {
                if (ch.getFechaConsulta().isAfter(fechaIngreso) && (ch.getFechaConsulta().isBefore(fechaActual) || ch.getFechaConsulta().isEqual(fechaActual))) {
                    consultasActuales.add(ch);
                }
            }
            return this.moduloEgresa.egresaPaciente(p, consultasActuales, this.lista_atendidos, dias);
        } else {
            throw new PacienteNoRegistradoException("El paciente no esta registrado en el sistema, no puede egresar.", p);
        }
    }

}
