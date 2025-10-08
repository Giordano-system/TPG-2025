package clases;

import excepciones.PacienteNoAtendidoException;
import interfaces.Interfaz_Medico;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase que representa el módulo de egreso de pacientes del sistema.
 * Permite gestionar el egreso de pacientes, generando la factura correspondiente y actualizando las listas de pacientes atendidos.
 * @version 1.0
 * @author Grupo 9 - POO
 */

public class ModuloEgresa {

    /**
     * Método para el egreso de un paciente.
     * <b>Pre:</b> p != null, lista_atendidos != null, dias > 0. El paciente debe haber sido atendido previamente y estar en la lista de atendidos.
     * <b>Post:</b> El paciente es removido de la lista de atendidos, se genera una factura por su atención y se actualizan las consultas médicas de los médicos
     * que lo atendieron. El paciente libera su habitación de internación.
     * @param p Paciente que egresa
     * @param lista_atendidos Lista de pacientes atendidos
     * @param dias Número de días que el paciente estuvo internado
     * @return Factura generada por el egreso del paciente
     */

    public Facturacion egresaPaciente(Paciente p, ArrayList<Paciente> lista_atendidos, int dias) throws PacienteNoAtendidoException {
        if (!lista_atendidos.contains(p)) {
            throw new PacienteNoAtendidoException("El paciente no ha sido atentido: ", p.getNombre(), p.getApellido(), p.getDni());
        } else {
            lista_atendidos.remove(p);
            Facturacion factura = new Facturacion(p,dias);
            for (Interfaz_Medico m : p.getConsultasMedicas()) {
                consultaMedicos(p, m);
            }
            p.clearHabitacionInternacion();
            return factura;
        }
    }

    /**
     * Método para el egreso de un paciente.
     * <b>Pre:</b> p != null, lista_atendidos != null.
     * <b>Post:</b> El paciente es removido de la lista de atendidos, se genera una factura por su atención y se actualizan las consultas médicas de los médicos
     * que lo atendieron.
     * @param p Paciente que egresa
     * @param lista_atendidos Lista de pacientes atendidos
     * @return Factura generada por el egreso del paciente
     */

    public Facturacion egresaPaciente(Paciente p, ArrayList<Paciente> lista_atendidos) throws PacienteNoAtendidoException {
        if (!lista_atendidos.contains(p)) {
            throw new PacienteNoAtendidoException("El paciente no ha sido atentido: ", p.getNombre(), p.getApellido(), p.getDni() );
        } else {
            lista_atendidos.remove(p);
            Facturacion factura = new Facturacion(p);
            for (Interfaz_Medico m : p.getConsultasMedicas()) {
                consultaMedicos(p, m);
            }
            return factura;
        }
    }

    /**
     * Método privado para registrar una consulta médica en el historial del médico.
     * <b>Pre:</b> p != null, m != null. El paciente y el médico deben ser instancias válidas.
     * <b>Post:</b> Se añade una nueva consulta médica al historial del médico.
     * @param p Paciente que fue atendido
     * @param m Médico que atendió al paciente
     */

    private void consultaMedicos(Paciente p, Interfaz_Medico m){
        Consulta consulta = new Consulta(p.getNombre(),LocalDate.now(), m.getSueldo()*1.20 );
        m.addConsultaMedica(consulta);
    }
}
