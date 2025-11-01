package Controlador;

import Vista.IVista;
import Vista.VistaConfig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    IVista vistaSim;
    VistaConfig vistaConfig;


    public Controlador(IVista vistaSim, VistaConfig vistaConfig) {
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


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Iniciar Simulacion")) {
            vistaConfig.setVisible(false);
            vistaSim.setVisible(true);
        }
    }


}
