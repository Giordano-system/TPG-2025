package prueba;

import Controlador.Controlador;
import Vista.IVista;
import Vista.VistaConfig;
import Vista.VistaSimulacion;

public class PruebaVistas {

    public static void main(String[] args) {
        IVista VistaSim = new VistaSimulacion();
        VistaConfig vistaConfig = new VistaConfig();
        Controlador controlador = new Controlador(VistaSim, vistaConfig);
    }

}
