package prueba;

import Controlador.Controlador;
import Modelo.Datos.clases.ModuloSimulacion;
import Modelo.Datos.clases.Sistema;
import Modelo.Negocio.clases.*;
import Patrones.Observer.ObservadorAmbulancia;
import Patrones.Observer.ObservadorAsociados;
import Patrones.Observer.ObservadorOperario;
import Vista.IVista;
import Vista.VistaConfig;
import Vista.VistaSimulacion;

import java.util.ArrayList;

public class PruebaVistas {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        IVista VistaSim = new VistaSimulacion();
        VistaConfig vistaConfig = new VistaConfig();
        Controlador controlador = new Controlador(VistaSim, vistaConfig, sistema);
    }
}
