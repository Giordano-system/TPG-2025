package Controlador;

import Modelo.Datos.clases.ModuloSimulacion;
import Modelo.Datos.clases.Sistema;
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
        if(estado.equals("Regresando del taller") && enSimulacion){
            vistaSim.activarTaller();
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
            modelo.setObservadores();
            modelo.iniciarSimulacion();
        } else if (command.equals("Finalizar")) {
            vistaSim.finalizarSimulacion();
            vistaSim.desactivarTaller();
            modelo.finalizarSimulacion();
        } else if(command.equals("Mantenimiento")){
            vistaSim.desactivarTaller(); //Para evitar multiples hilos de mantenimiento.
            modelo.mandarAMantenimiento();
        }
    }


}
