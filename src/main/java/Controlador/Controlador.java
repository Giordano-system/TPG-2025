package Controlador;

import Modelo.Datos.clases.ModuloSimulacion;
import Modelo.Datos.clases.Sistema;
import Persistencia.excepciones.AsociadoExistenteException;
import Persistencia.excepciones.AsociadoInexistenteException;
import Vista.IVista;
import Vista.VistaConfig;
import prueba.PruebaVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    IVista vistaSim;
    VistaConfig vistaConfig;
    Sistema modelo;


    public Controlador(IVista vistaSim, VistaConfig vistaConfig, Sistema modelo) {
        this.modelo = modelo;
        this.vistaSim = vistaSim;
        this.modelo.crearObservadores(this);
        vistaSim.setActionListener(this);
        this.vistaConfig = vistaConfig;
        vistaConfig.setActionListener(this);
        vistaSim.setVisible(false);
        vistaConfig.setVisible(true);
    }

    public void actualizarAreaOperario(String mensaje) {
        vistaSim.mensajeOperarioAmbulancia(mensaje);
    }

    /**
     * Actualiza el estado de la ambulancia en la vista de simulacion.
     * @param estado Nuevo estado de la ambulancia. Si este estado es regresando del taller, se vuelve a activar la opcion de mantenimiento en la vista. Ya que
     * <b>Post: Se actualiza el estado de la ambulancia en la interfaz</b>
     */

    public void actualizarEstadoAmbulancia(String estado, Boolean enSimulacion) {
        vistaSim.actualizarEstadoAmb("");
        if(estado.equals("Regresando del taller") && enSimulacion){
            vistaSim.activarTaller();
        }
        if (!enSimulacion){
            System.out.println("Finalizo la simulacion");
            estado = "Simulacion finalizada.";
            vistaSim.finalizarSimulacion();
        }
        vistaSim.actualizarEstadoAmb(estado);
    }

    public void actualizarVistaAsociado(String mensaje) {
        vistaSim.mensajeAsociado(mensaje);
    }

    /**
     * <b>Post: Los hilos se van a terminar de ejecutar.</b>
     */

    public void finalizarSimulacion(){
        vistaSim.finalizarSimulacion();
        vistaSim.mensajeAsociado("Simulacion Finalizada con exito.");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Iniciar Simulacion")) {
            int numAsociados = vistaConfig.getNumAsociados();
            int numSolicitudes = vistaConfig.getNumSolicitudes();
            modelo.configurarSimulacion(numAsociados, numSolicitudes);
            vistaConfig.setVisible(false);
            vistaSim.setVisible(true);
            vistaSim.setearListas(modelo.getAsociados());
            vistaSim.setearOpeario(modelo.getOperario());
        } else if (command.equals("Finalizar")) {
            vistaSim.finalizarSimulacion();
            vistaSim.desactivarTaller();
            modelo.finalizarSimulacion();
        } else if(command.equals("Mantenimiento")){
            vistaSim.desactivarTaller(); //Para evitar multiples hilos de mantenimiento.
            modelo.mandarAMantenimiento();
        } else if(command.equals("Reiniciar")){
            int numAsociados = vistaConfig.getNumAsociados();
            int numSolicitudes = vistaConfig.getNumSolicitudes();
            modelo.configurarSimulacion(numAsociados, numSolicitudes);
            vistaSim.setearListas(modelo.getAsociados());
            vistaSim.setearOpeario(modelo.getOperario());
            vistaSim.iniciarSimulacion();
            vistaSim.limpiarTextAreas();
            vistaSim.limpiarCampos();
        } else if(command.equals("Reiniciar BD")) {
            modelo.reiniciarBD();
            vistaSim.setearListas(modelo.getAsociados());
        } else if(command.equals("Alta de Asociado")){
            String nombre = vistaSim.getNombreAsociado();
            String apellido = vistaSim.getApellidoAsociado();
            String dni = vistaSim.getDNIAsociado();
            String calle = vistaSim.getCalleAsociado();
            int numero = vistaSim.getNumeroAsociado();
            String ciudad = vistaSim.getCiudadAsociado();
            String telefono = vistaSim.getTelefonoAsociado();
            try {
                modelo.altaAsociado(nombre, apellido, dni, calle, numero, telefono, ciudad);
                vistaSim.mensajeAsociado("Asociado dado de alta correctamente.");
                vistaSim.setearListas(modelo.getAsociados());
            } catch (AsociadoExistenteException ex) {
                vistaSim.mensajeAsociado("Error al dar de alta el asociado." + "El asociado con DNI: " + ex.getA().getDni() + " ya existe en la base de datos.");
            }
        } else if (command.equals("Baja de Asociado")) {
            String nombre = vistaSim.getNombreAsociado();
            String apellido = vistaSim.getApellidoAsociado();
            String dni = vistaSim.getDNIAsociado();
            String calle = vistaSim.getCalleAsociado();
            int numero = vistaSim.getNumeroAsociado();
            String ciudad = vistaSim.getCiudadAsociado();
            String telefono = vistaSim.getTelefonoAsociado();
            try {
                modelo.bajaAsociado(nombre, apellido, dni, calle, numero, telefono, ciudad);
                vistaSim.mensajeAsociado("Asociado dado de baja correctamente.");
                vistaSim.setearListas(modelo.getAsociados());
            } catch (AsociadoInexistenteException ex) {
                vistaSim.mensajeAsociado("Error al dar de baja el asociado." + "El asociado con DNI: " + ex.getA().getDni() + " no existe en la base de datos.");
            }
        }
    }


}
