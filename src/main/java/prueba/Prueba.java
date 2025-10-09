package prueba;

import clases.*;
import interfaces.*;
import excepciones.*;

import java.time.LocalDate;

/**
 * Clase de prueba para el sistema de gestión de médicos.
 * @author Grupo 9 - POO
 * @version 1.0
 */

@SuppressWarnings("unused")
public class Prueba
{

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Interfaz_Medico m= sistema.getMedicos().get(1);
        sistema.addMedico("Magister", "Residente", "Clinica", "Juan", "Perez", "12345678", "Springfield", 1459, "223 596 4847", "Simpsons", 50000);
        Joven p1 = new Joven("Juan", "Aldana", "44692708", "Los Pilagas", 1805, "5492235403755", "Mar del Plara");
        Consulta c = new Consulta("Carlos", LocalDate.of(2024, 6, 15), m.getSueldo());
        Consulta c2 = new Consulta("Agustin", LocalDate.of(2024, 9, 15), m.getSueldo());

        try {
            sistema.registraPaciente(p1);
            sistema.ingresaPaciente(p1);
            sistema.atiendoPaciente(p1, m);
            sistema.internaPaciente(p1,"Habitacion Compartida");
            sistema.registrarConsultaMedico(p1, m);
            sistema.registrarConsultaPaciente(p1, m);
        }
        catch (PacienteNoRegistradoException e) {
            System.out.println("Error: " + e.getMessage());
            sistema.registraPaciente(e.getPaciente());
        }
        catch (MedicoNoRegistradoException e){
            System.out.println("Error: " + e.getMessage());
            sistema.addMedico(e.getMedico());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}


