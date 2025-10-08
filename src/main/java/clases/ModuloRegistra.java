package clases;

import java.util.ArrayList;

/**
 * Clase que representa el módulo de registro de pacientes en el sistema.
 * Permite añadir pacientes a la lista de espera.
 * @version 1.0
 * @author Grupo 9 - POO
 */

public class ModuloRegistra {
        /**
        @param p El paciente a registrar.
        @param lista_espera La lista de espera donde se registrará el paciente.
        <b> Pre: </b> El paciente p no debe ser null. La lista de espera lista_espera no debe ser null.
        <b> Post: </b> El paciente p se ha añadido a la lista de espera.
        */

        public void registraPaciente(Paciente p, ArrayList<Paciente> lista_espera) {
            lista_espera.add(p);
        }
}
