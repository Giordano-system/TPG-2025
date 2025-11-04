package Vista;

import Modelo.Negocio.clases.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IVista {

    void setActionListener (ActionListener actionListener);

    void actualizarCampos(Asociado asociado);

    void limpiarCampos();

    void mensajeAsociado(String mensaje);

    void actualizarEstadoAmb(String estado);

    void mensajeOperarioAmbulancia(String mensaje);

    void setearOpeario(Operario operario);

    void setearListas(ArrayList<Asociado> lista);

    void setVisible(boolean b);

    void finalizarSimulacion();

}
