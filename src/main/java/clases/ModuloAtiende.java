package clases;

import interfaces.Interfaz_Medico;

import java.util.ArrayList;

public class ModuloAtiende {

    /**
     * <b> Pre: </b> El paciente p, el médico m, las listas Lista_espera, Lista_atendidos, patio y la sala no deben ser null.
     * El paciente debe estar en la lista de espera o la lista de atendidos (El paciente es atendido por mas de un medico).
     * @param p Paciente a ser atendido.
     * @param m Médico que atiende al paciente.
     * @param Lista_espera Lista de espera de pacientes.
     * @param Lista_atendidos Lista de pacientes atendidos.
     * @param patio Patio de espera.
     * @param sala Sala de espera.
     *<b> Post: </b> El paciente p es atendido por el médico m. El paciente se elimina de la lista de espera y se añade a la lista de atendidos si no estaba ya en ella.
     * Si el paciente estaba en la sala, se elimina de la sala. Si estaba en el patio, se elimina del patio.
     */

    public void atiendoPaciente(Paciente p, Interfaz_Medico m, ArrayList<Paciente> Lista_espera, ArrayList<Paciente> Lista_atendidos, Patio patio, Sala sala) {
        p.addConsultaMedica(m);
        if (Lista_espera.contains(p)) {
            ArrayList<Paciente> PacientesPatio = patio.getPacientes();
            if (PacientesPatio.contains(p)) {
                patio.eliminaPaciente(p);
            } else {
                sala.eliminaPaciente();
            }
            Lista_espera.remove(p);
            Lista_atendidos.add(p);
        }
    }
}
