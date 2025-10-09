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
        Facturacion factura1 = null;
        Facturacion factura2 = null;
        Facturacion factura3 = null;
        Sistema sistema = new Sistema();
        Interfaz_Medico m1= sistema.getMedicos().get(5);
        Interfaz_Medico m2= sistema.getMedicos().get(2);
        Interfaz_Medico m3= sistema.getMedicos().get(3);
        sistema.addMedico("Magister", "Residente", "Clinica", "Juan", "Perez", "12345678", "Springfield", 1459, "223 596 4847", "Simpsons", 50000);
        Joven p1 = new Joven("Juan", "Aldana", "44692708", "Los Pilagas", 1805, "5492235403755", "Mar del Plara");
        Mayor p2 = new Mayor("Antonio","Rudiger","17569842","Alemania",1563,"155248968","Berlin");
        Nino p3 = new Nino("Algo","Alguito","20000000","Calle",1111,"1111111111111","ciudad");

        try {
            sistema.registraPaciente(p1);
            sistema.registraPaciente(p2);
            sistema.registraPaciente(p3);
            sistema.ingresaPaciente(p1);
            sistema.ingresaPaciente(p2);
            sistema.ingresaPaciente(p3);
            sistema.atiendoPaciente(p1, m1);
            sistema.atiendoPaciente(p1
                    , m2);
            sistema.atiendoPaciente(p2, m2);
            sistema.atiendoPaciente(p3, m3);
            sistema.atiendoPaciente(p3, m1);
            sistema.internaPaciente(p1,"Habitacion Compartida");
            sistema.internaPaciente(p2,"Habitacion Privada");
            factura1=sistema.egresaPaciente(p1,10);
            factura2=sistema.egresaPaciente(p2,3);
            factura3=sistema.egresaPaciente(p3);
            System.out.println(factura1.toString());
            System.out.println(factura2.toString());
            System.out.println(factura3.toString());
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


