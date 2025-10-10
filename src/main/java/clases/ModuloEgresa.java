package clases;

import excepciones.PacienteNoAtendidoException;
import interfaces.Interfaz_Medico;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Clase que representa el módulo de egreso de pacientes del sistema.
 * Permite gestionar el egreso de pacientes, generando la factura correspondiente y actualizando las listas de pacientes atendidos.
 * @version 1.0
 * @author Grupo 9 - POO
 */

public class ModuloEgresa {

    /**
     * Método para el egreso de un paciente.
     * <b>Pre:</b> p != null, consultasMedicas!=null ,lista_atendidos != null, dias > 0. El paciente debe haber sido atendido previamente y estar en la lista de atendidos.
     * <b>Post:</b> El paciente es removido de la lista de atendidos, se genera una factura por su atención y se actualizan las consultas médicas de los médicos
     * que lo atendieron. El paciente libera su habitación de internación.
     * @param p Paciente que egresa
     * @param consultasMedicas Lista de consultas médicas realizadas al paciente
     * @param lista_atendidos Lista de pacientes atendidos
     * @param dias Número de días que el paciente estuvo internado
     * @return Factura generada por el egreso del paciente
     */

    public Facturacion egresaPaciente(Paciente p, ArrayList<ConsultasHistoricas> consultasMedicas ,ArrayList<Paciente> lista_atendidos, int dias) throws PacienteNoAtendidoException {
        if (!lista_atendidos.contains(p)) {
            throw new PacienteNoAtendidoException("El paciente no ha sido atentido: ", p);
        } else {
            lista_atendidos.remove(p);
            Facturacion factura = new Facturacion(p, consultasMedicas ,dias);
            p.clearHabitacionInternacion();
            return factura;
        }
    }

    /**
     * Método para el egreso de un paciente.
     * <b>Pre:</b> p != null, lista_atendidos != null. El paciente debe haber sido atendido previamente y estar en la lista de atendidos.
     * ConsultasMedicas puede ser una lista vacía si el paciente no tuvo consultas previas
     * <b>Post:</b> El paciente es removido de la lista de atendidos, se genera una factura por su atención y se actualizan las consultas médicas de los médicos
     * que lo atendieron.
     * @param p Paciente que egresa
     * @param consultasMedicas Lista de consultas médicas realizadas al paciente
     * @param lista_atendidos Lista de pacientes atendidos
     * @return Factura generada por el egreso del paciente
     */

    public Facturacion egresaPaciente(Paciente p, ArrayList<ConsultasHistoricas> consultasMedicas ,ArrayList<Paciente> lista_atendidos) throws PacienteNoAtendidoException {
        if (!lista_atendidos.contains(p)) {
            throw new PacienteNoAtendidoException("El paciente no ha sido atentido: ", p);
        } else {
            lista_atendidos.remove(p);
            return new Facturacion(p, consultasMedicas);
        }
    }

}
