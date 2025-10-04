package clases;


/**
 * Clase del Módulo para el Ingreso de los pacientes.
 * @author Grupo 9 - POO
 * @version 1.0
 */
public class ModuloIngresa {

	/**
	 *	Método para ingresar un paciente en la sala o patio. 
	 * 	<b>PRE:</b> s != null, p != null, paciente != null.
	 *  @param s Sala de espera
	 *  @param p Patio de espera
	 *  @param paciente Paciente que acaba de ingresar
	 * 	<b>POST:</b> el paciente se queda esperando en la sala o en el patio. 
	 */

	public void ubicoPaciente(Sala s, Patio p, Paciente paciente) {
		if(s.getPaciente() == null)
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
