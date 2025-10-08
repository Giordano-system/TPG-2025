package clases;

import interfaces.Interfaz_Especialidad;
import interfaces.Interfaz_Medico;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que genera y guarda facturas de los clientes.
 * Distingue clientes que han recibido o no una internacion.
 * @author Grupo 9 - POO
 * @version 1.00
 */

public class Facturacion {

	private static int contFacturas;
	private int nroFactura;
	private Paciente paciente;
    private Habitacion habitacionOcupada;
    private ArrayList<Interfaz_Medico> consultasMedicas;
	private int cantDias;
	private double costoInternacion;
	private double total=0;
	private LocalDate fechaEgreso=LocalDate.now();

/**
 * Constructor base de la clase.
 * @param paciente Paciente !=null
 */
	public Facturacion(Paciente paciente) {
		this.nroFactura+= contFacturas+1;
		this.consultasMedicas=paciente.getConsultasMedicas();
		for (int i=0; i<this.consultasMedicas.size(); i++) {
			this.total+=this.consultasMedicas.get(i).getSueldo()*1.20;
		}
	}

/**
 * Contructor sobreecargado con dias, implica una internacion de dias dias.
 * @param paciente
 * @param dias
 */
	
	public Facturacion(Paciente paciente, int dias) {
		this(paciente);
        this.habitacionOcupada = paciente.getHabitacionInternacion();
		this.costoInternacion= this.paciente.getHabitacionInternacion().devolverCosto(dias);	
		this.total+=this.costoInternacion;
		this.cantDias=dias;
	}
	
/**
 * Impresion consultas.
 * Imprime las consultas del paciente, con sus respectivos medicos y valores. 
 */
	
	private String ArmaConsultas() {
		String aux="";
		for (int i=0; i<this.consultasMedicas.size(); i++)
			aux+= "\nNombre Medico: " + consultasMedicas.get(i).getNombre() + 
				  "     Especialidad: " + consultasMedicas.get(i).getEspecialidad() + 
				  "     Subtotal: $" + consultasMedicas.get(i).getSueldo()*1.20;
		return aux;
	}

/*
 * To string de la factura.
 * Diferencia con o sin internacion, invoca la impresion de las consultas.
 */

	@SuppressWarnings("static-access")
	@Override
	public String toString(){
		if (this.cantDias>0)
			return "Nº Factura: " + this.nroFactura 
					+ "\nNombrePaciente: " + this.paciente.getNombre() 
					+ " " + this.paciente.getApellido() 
					+ "\nFecha Ingreso: " + this.fechaEgreso.minusDays(cantDias) 
					+ "\nFechaEgreso: " + this.fechaEgreso 
					+ "\nCantidad de Dias: " + this.cantDias 
					+ "\nHabitacion Tipo: " + this.habitacionOcupada.getTipo()
					+ "     Costo: $" + this.costoInternacion
					+ "\n\nConsultas Medicas:\n " + this.ArmaConsultas() 
					+ "\n\n             Total: $" + this.total; 
		else
			return "Nº Factura: " + this.nroFactura 
					+ "\nNombrePaciente: " + this.paciente.getNombre() + " " + this.paciente.getApellido() 
					+ "\nFecha: " + this.fechaEgreso 
					+ "\n\nConsultas Medicas:\n " + this.ArmaConsultas() 
					+ "\n\n             Total: $" + this.total;
	}
}
