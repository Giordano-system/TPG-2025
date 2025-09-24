package interfaces;

import clases.Paciente;

/**
 * Interfaz que define métodos para comparar pacientes según su rango etario.
 * Implementada por la clase Paciente y sus subclases.
 * @author Grupo 9 - POO
 * @version 1.0
 */

public interface IPacientesComparables {

    /**
     * Compara dos pacientes por su rango etario.
     * @param p Paciente recien ingresado. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que llama al metodo, false en caso contrario.
     */
    boolean comparoPaciente(Paciente p);

    /**
     * Compara al paciente actualmente en la sala de espera con un paciente mayor.
     * @param p Paciente que esta actualmente en la sala de espera. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */

    boolean comparoMayores(Paciente p);

    /**
     * Compara al paciente en la sala de espera con un paciente joven.
     * @param p Paciente que esta actualmente en la sala de espera. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */


    boolean comparoJovenes(Paciente p);

    /**
     * Compara al paciente en la sala de espera con un paciente nino.
     * @param p Paciente que esta actualmente en la sala de espera. Instancia de una subclase de Paciente.
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */

    boolean comparoNinos(Paciente p);
}
