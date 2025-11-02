package prueba;

import Controlador.Controlador;
import Modelo.Datos.clases.ModuloSimulacion;
import Modelo.Negocio.clases.*;
import Patrones.Observer.ObservadorAmbulancia;
import Patrones.Observer.ObservadorAsociados;
import Vista.IVista;
import Vista.VistaConfig;
import Vista.VistaSimulacion;

import java.util.ArrayList;

public class PruebaVistas {


    public static void main(String[] args) {
        ModuloSimulacion moduloSimulacion = new ModuloSimulacion();
        IVista vista = new VistaSimulacion();
        VistaConfig vistaConfig = new VistaConfig();
        Controlador controlador = new Controlador(vista, vistaConfig, moduloSimulacion);
        ObservadorAmbulancia observadorAmbulancia = new ObservadorAmbulancia(controlador);
        ObservadorAsociados observadorAsociados = new ObservadorAsociados(controlador);
        moduloSimulacion.agregarObservadores(observadorAsociados, observadorAmbulancia);

    }


}
