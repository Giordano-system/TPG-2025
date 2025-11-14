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
import java.awt.event.WindowAdapter;

/**
 * Controlador de la aplicacion. Se encarga de recibir los eventos de la vista y actualizar el modelo y la vista en consecuencia.
 * @author Grupo 9 - POO
 * @version 2.0
 */

public class Controlador extends WindowAdapter implements ActionListener {
    IVista vistaSim;
    VistaConfig vistaConfig;
    Sistema modelo;


    public Controlador(IVista vistaSim, VistaConfig vistaConfig, Sistema modelo) {
        super();
        this.modelo = modelo;
        this.vistaSim = vistaSim;
        this.modelo.crearObservadores(this);
        vistaSim.setActionListener(this);
        vistaSim.setWindowListener(this);
        this.vistaConfig = vistaConfig;
        vistaConfig.setActionListener(this);
        vistaSim.setVisible(false);
        vistaConfig.setVisible(true);
    }

    /**
     * Actualiza el area de texto del operario en la vista de simulacion.
     * @param mensaje Mensaje a mostrar en el area de texto del operario.
     * <b>Post: Se actualiza el area de texto del operario en la interfaz</b>
     */

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

        vistaSim.actualizarEstadoAmb(estado);
    }

    /**
     * Finaliza la simulacion en la vista de simulacion.
     * @param estado Estado final de la simulacion.
     * @param enSimulacion Booleano que indica si la simulacion sigue en curso.
     * <b>Post: Se finaliza la simulacion en la interfaz</b>
     */

    public void finalizarSim(String estado, Boolean enSimulacion) {
        if (!enSimulacion){
            estado = "Simulacion finalizada.";
            vistaSim.finalizarSimulacion();
            vistaSim.actualizarEstadoAmb(estado);
        }
    }

    /**
     * Actualiza la vista del asociado en la vista de simulacion.
     * @param mensaje Mensaje a mostrar en la vista del asociado.
     * <b>Post: Se actualiza la vista del asociado en la interfaz</b>
     */

    public void actualizarVistaAsociado(String mensaje) {
        vistaSim.mensajeAsociado(mensaje);
    }

    /**
     * Procesa los eventos generados por la vista.
     * @param e the event to be processed
     * <b>Post: Se procesa el evento generado por la vista</b>
     */

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
            vistaSim.desactivarTaller();
            modelo.finalizarSimulacion();
        } else if(command.equals("Mantenimiento")){
            vistaSim.desactivarTaller(); //Para evitar multiples hilos de mantenimiento.
            modelo.mandarAMantenimiento();
        } else if(command.equals("Reiniciar")){

            vistaSim.iniciarSimulacion();
            vistaSim.limpiarTextAreas();
            vistaSim.limpiarCampos();
            
            vistaSim.setearListas(modelo.getAsociados());
            vistaSim.setearOpeario(modelo.getOperario());

            int numAsociados = vistaSim.getNumAsociados();
            int numSolicitudes = vistaSim.getNumSolicitudes();
            
            modelo.reiniciarSimulacion(numAsociados, numSolicitudes);
            
            vistaSim.limpiarCamposSim();

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
        } else if(command.equals("Limpiar Campos")){
            vistaSim.limpiarCampos();
        }
    }

    /**
     * Procesa el evento de cierre de la ventana.
     * @param e the event to be processed
     */

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {

        try {
            // 1. Le pide al Modelo que cierre la conexión
            this.modelo.cerrarConexionDB();

        } catch (Exception ex) {
            System.err.println("Error al cerrar la BD: " + ex.getMessage());
        } finally {
            // 2. Cierra la aplicación
            System.exit(0);
        }
    }


}
