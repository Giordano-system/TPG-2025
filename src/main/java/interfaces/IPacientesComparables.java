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
     * Compara al paciente que acaba de ingresar con un paciente mayor (que ya estaba en la sala).
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */

    boolean comparoMayores();

    /**
     * Compara al paciente que acaba de ingresar con un paciente joven (que ya estaba en la sala).
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */


    boolean comparoJovenes();

    /**
     * Compara al paciente que acaba de ingresar con un paciente niño (que ya estaba en la sala).
     * @return true si quien se queda en la sala de espera es el paciente que ya estaba, false en caso contrario.
     */

    boolean comparoNinos();
}
