package clases;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase que representa el módulo de egreso de pacientes del sistema.
 * Permite gestionar el egreso de pacientes, generando la factura correspondiente y actualizando las listas de pacientes atendidos.
 * @version 1.0
 * @author Grupo 9 - POO
 */

public class ModuloEgresa {


    public Facturacion egresaPaciente(Paciente p, ArrayList<Paciente> lista_atendidos, int dias) {
        lista_atendidos.remove(p);
        Facturacion factura = new Facturacion(p,dias);
        for (Medico m : p.getConsultasMedicas()) {
            consultaMedicos(p, m);
        }
        p.clearHabitacionInternacion();
        return factura;
    }

    public Facturacion egresaPaciente(Paciente p, ArrayList<Paciente> lista_atendidos) {
        lista_atendidos.remove(p);
        Facturacion factura = new Facturacion(p);
        for (Medico m : p.getConsultasMedicas()) {
            consultaMedicos(p, m);
        }
        return factura;
    }

    private void consultaMedicos(Paciente p, Medico m){
        Consulta consulta = new Consulta(p.getNombre(),LocalDate.now(), m.getSueldo()*1.20 );
        m.addConsultaMedica(consulta);
    }
}
