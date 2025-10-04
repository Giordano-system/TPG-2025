package clases;

import java.util.ArrayList;

public class ModuloRegistra {
        /**
        @param p El paciente a registrar.
        @param lista_espera La lista de espera donde se registrará el paciente.
        <b> Pre: </b> El paciente p no debe ser null. La lista de espera lista_espera no debe ser null.
        <b> Post: </b> El paciente p se ha añadido a la lista de espera.
        */

        public void registrarPaciente(Paciente p, ArrayList<Paciente> lista_espera) {
            lista_espera.add(p);
        }
}
