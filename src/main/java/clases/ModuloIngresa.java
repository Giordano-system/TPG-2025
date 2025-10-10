package clases;

import java.util.ArrayList;

import excepciones.PacienteNoRegistradoException;

/**
 * Clase del Módulo para el Ingreso de los pacientes.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class ModuloIngresa {

	/**
	 *	Método para ingresar un paciente en la sala o patio. 
	 * 	<b>PRE:</b> s != null, p != null, paciente != null.
	 *  @param lista_espera Lista de espera de los pacientes registrados.
	 *  @param s Sala de espera
	 *  @param p Patio de espera
	 *  @param paciente Paciente que acaba de ingresar
	 * 	<b>POST:</b> el paciente se queda esperando en la sala o en el patio. 
	 * @throws PacienteNoRegistradoException Si el paciente no esta en la lista de espera (no se registro) propaga excepcion
	 */

	public void ingresaPaciente(ArrayList<Paciente> lista_espera, Sala s, Patio p, Paciente paciente) throws PacienteNoRegistradoException {
		if(!lista_espera.contains(paciente))
			throw new PacienteNoRegistradoException("El paciente no esta registrado.",paciente);
		else if(s.getPaciente() == null)
			s.agregaPaciente(paciente);
		else if(s.getPaciente().comparoPaciente(paciente))
			p.agregaPaciente(paciente);
		else {
			p.agregaPaciente(s.getPaciente());
			s.eliminaPaciente();
			s.agregaPaciente(paciente);
		}
	}
	
}
