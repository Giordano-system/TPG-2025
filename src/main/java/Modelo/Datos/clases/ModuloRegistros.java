package Modelo.Datos.clases;

import Modelo.Datos.interfaces.Interfaz_Medico;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que maneja el registro de consultas médicas de los pacientes.
 * Y tambien las consultas medicas individuales de cada Medico.
 * @version 1.0
 * @author Grupo 9 - POO
 */

public class ModuloRegistros {

    /**
     * Registra una nueva consulta médica para un paciente específico.
     * <b>Pre:</b> p != null, m != null, consultasMedicas != null.
     * <b>Post:</b> Se agrega una nueva consulta a la lista de consultas del paciente en el HashMap.
     * Se crea una nueva instancia de ConsultasHistoricas con los datos del médico y la fecha actual.
     * @param p Paciente que recibe la consulta
     * @param m Medico que realiza la consulta
     * @param consultasMedicas HashMap que asocia el número de historia clínica del paciente con su lista de consultas médicas
     */

    public void registrarConsultaPaciente(Paciente p, Interfaz_Medico m, HashMap<Integer, ArrayList<ConsultasHistoricas>> consultasMedicas) {
        ConsultasHistoricas c = new ConsultasHistoricas(m.getNombre(), m.getEspecialidad(), m.getSueldo()*1.20, java.time.LocalDate.now());
        consultasMedicas.get(p.getNumHistoriaClinica()).add(c);
    }

    /**
     * Registra una nueva consulta médica para un médico específico.
     * <b>Pre:</b> p != null, m != null, consultasMedicasMedico != null.
     * <b>Post:</b> Se agrega una nueva consulta a la lista de consultas del médico en el HashMap.
     * @param p Paciente que recibe la consulta
     * @param m Medico que realiza la consulta
     * @param consultasMedicasMedico HashMap que asocia la matrícula del médico con su lista de consultas médicas
     */

    public void registrarConsultaMedico(Paciente p, Interfaz_Medico m, HashMap<Integer, ArrayList<Consulta>> consultasMedicasMedico) {
        Consulta c = new Consulta(p.getNombre(), java.time.LocalDate.now(), m.getSueldo()*1.20 );
        consultasMedicasMedico.get(m.getMatricula()).add(c);
    }

    /**
     * Agrega un nuevo paciente al sistema, inicializando su lista de consultas médicas.
     * <b>Pre:</b> p != null, consultasMedicas != null.
     * <b>Post:</b> Se agrega el paciente al HashMap con una lista vacía de consultas.
     * @param p Paciente a ser agregado
     * @param consultasMedicas HashMap que asocia el número de historia clínica del paciente con su lista de consultas médicas
     */

    public void addPaciente(Paciente p, HashMap<Integer, ArrayList<ConsultasHistoricas>> consultasMedicas) {
        if (!consultasMedicas.containsKey(p.getNumHistoriaClinica())) {
            consultasMedicas.put(p.getNumHistoriaClinica(), new ArrayList<ConsultasHistoricas>());
        }
    }

    /**
     * Agrega un nuevo médico al sistema, inicializando su lista de consultas médicas.
     * <b>Pre:</b> m != null, consultasMedicasMedico != null.
     * <b>Post:</b> Se agrega el médico al HashMap con una lista vacía de consultas.
     * @param m Medico a ser agregado
     * @param consultasMedicasMedico HashMap que asocia la matrícula del médico con su lista de consultas médicas
     */

    public void addMedico(Interfaz_Medico m, HashMap<Integer, ArrayList<Consulta>> consultasMedicasMedico) {
        if (!consultasMedicasMedico.containsKey(m.getMatricula())) {
            consultasMedicasMedico.put(m.getMatricula(), new ArrayList<Consulta>());
        }
    }

    public void reportarActividadMedica(Interfaz_Medico m, HashMap<Integer, ArrayList<Consulta>> consultasMedicasMedico) {
        double totalHonorarios = 0;
        System.out.println("Consultas realizadas por el medico " + m.getNombre() + ": \n");
        for (Consulta c : consultasMedicasMedico.get(m.getMatricula())) {
            totalHonorarios += c.getHonorarioMedico();
            System.out.println("Paciente: " + c.getNombrePaciente() + ", Fecha: " + c.getFecha() + ", Honorario: $" + c.getHonorarioMedico() + "\n");
        }
        System.out.println("Total de honorarios generados por el medico " + m.getNombre() + ": $" + totalHonorarios + "\n");
    }

}
