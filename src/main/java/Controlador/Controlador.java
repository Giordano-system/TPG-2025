package Controlador;

import Modelo.Datos.clases.ModuloSimulacion;
import Vista.IVista;
import Vista.VistaConfig;
import prueba.PruebaVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    IVista vistaSim;
    VistaConfig vistaConfig;
    ModuloSimulacion modelo;


    public Controlador(IVista vistaSim, VistaConfig vistaConfig, ModuloSimulacion modelo) {
        this.modelo = modelo;
        this.vistaSim = vistaSim;
        vistaSim.setActionListener(this);
        this.vistaConfig = vistaConfig;
        vistaConfig.setActionListener(this);
        vistaSim.setVisible(false);
        vistaConfig.setVisible(true);
    }

    public void actualizarEstadoAmbulancia(String estado) {
        vistaSim.actualizarEstadoAmb(estado);
    }

    public void actualizarVistaAsociado(String mensaje) {
        vistaSim.mensajeAsociado(mensaje);
    }

    public void finalizarSimulacion(){
        vistaSim.finalizarSimulacion();
        vistaSim.mensajeAsociado("Simulacion Finalizada con exito.");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Iniciar Simulacion")) {
            vistaConfig.setVisible(false);
            vistaSim.setVisible(true);
            vistaSim.setearListas(modelo.getAsociados());
            modelo.iniciarSimulacion();
        }
    }


}
