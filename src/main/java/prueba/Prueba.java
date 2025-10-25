package prueba;

import Modelo.Datos.clases.*;
import Modelo.Datos.interfaces.*;



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
        sistema.addMedico("Magister", "Residente", "Clinica", "Juan", "Perez", "12345678", "Springfield", 1459, "2235964847", "Simpsons", 50000);
        Joven p1 = new Joven("Juan", "Aldana", "44692708", "Los Pilagas", 1805, "5492235403755", "Mar del Plata");
        Mayor p2 = new Mayor("Antonio","Rudiger","17569842","Alemania",1563,"155248968","Berlin");
        Nino p3 = new Nino("Pedro","Villarreal","51123456","12 de Octubre",2345,"2236459898","Buenos Aires");

        sistema.registraPaciente(p1);
        sistema.registraPaciente(p2);
        sistema.registraPaciente(p3);
        
        try {
			sistema.ingresaPaciente(p1);
		} catch (PacienteNoRegistradoException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.ingresaPaciente(p2);
		} catch (PacienteNoRegistradoException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.ingresaPaciente(p3);
		} catch (PacienteNoRegistradoException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.atiendoPaciente(p1, m1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.atiendoPaciente(p1, m2);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.atiendoPaciente(p2, m2);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.atiendoPaciente(p3, m3);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.atiendoPaciente(p3, m1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			sistema.internaPaciente(p1,"Habitacion Compartida");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
        	sistema.internaPaciente(p2,"Habitacion Privada");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
			factura1=sistema.egresaPaciente(p1,10);
			System.out.println(factura1.toString());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
        	factura2=sistema.egresaPaciente(p2,3);
        	System.out.println(factura2.toString());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        try {
        	factura3=sistema.egresaPaciente(p3);
        	System.out.println(factura3.toString());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
}


