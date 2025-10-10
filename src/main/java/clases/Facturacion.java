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

	private static int contFacturas=0;
	private int nroFactura;
	private Paciente paciente;
    private Habitacion habitacionOcupada;
    private ArrayList<ConsultasHistoricas> consultasMedicas;
	private int cantDias;
	private double costoInternacion;
	private double total=0;
	private LocalDate fechaEgreso=LocalDate.now();

/**
 * Constructor base de la clase.
 * @param paciente Paciente !=null
 */
	public Facturacion(Paciente paciente, ArrayList<ConsultasHistoricas> consultasMedicas) {
        this.cantDias=0;
        this.paciente = paciente;
		this.nroFactura+= ++contFacturas;
		this.consultasMedicas= consultasMedicas;
		for (int i=0; i<this.consultasMedicas.size(); i++) {
			this.total+=this.consultasMedicas.get(i).getHonorarioTotal();
		}
	}

/**
 * Contructor sobreecargado con dias, implica una internacion de dias dias.
 * @param paciente
 * @param dias
 */
	
	public Facturacion(Paciente paciente, ArrayList<ConsultasHistoricas> consultasMedicas , int dias) {
		this(paciente,consultasMedicas);
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
        for (int i=0; i<this.consultasMedicas.size(); i++) {
            aux += this.consultasMedicas.get(i).toString();
        }
        return aux;
	}

/**
 * To string de la factura.
 * Diferencia con o sin internacion, invoca la impresion de las consultas.
 */

	@SuppressWarnings("static-access")
	@Override
	public String toString(){
		if (this.cantDias>0)
			return "\n\n\nNº Factura: " + this.nroFactura
					+ "\nNombrePaciente: " + this.paciente.getNombre() 
					+ " " + this.paciente.getApellido() 
					+ "\nFecha Ingreso: " + this.fechaEgreso.minusDays(cantDias) 
					+ "\nFecha Egreso: " + this.fechaEgreso
					+ "\nCantidad de Dias: " + this.cantDias 
					+ "\nHabitacion Tipo: " + this.habitacionOcupada.getTipo()
					+ "     Costo: $" + Math.round(this.costoInternacion * 100.0) / 100.0
					+ "\n\nConsultas Medicas:\n " + this.ArmaConsultas()
					+ "\n\n             Total: $" + Math.round(this.total * 100.0) / 100.0; 
		else
			return "\n\n\nNº Factura: " + this.nroFactura
					+ "\nNombrePaciente: " + this.paciente.getNombre() + " " + this.paciente.getApellido() 
					+ "\nFecha: " + this.fechaEgreso 
					+ "\n\nConsultas Medicas:\n " + this.ArmaConsultas() 
					+ "\n\n             Total: $" + Math.round(this.total * 100.0) / 100.0;
	}
}
