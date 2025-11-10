package Vista;

import Modelo.Negocio.clases.*;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public interface IVista {

    void setActionListener (ActionListener actionListener);

    void setWindowListener (WindowListener windowListener);

    void actualizarCampos(Asociado asociado);

    void limpiarCampos();

    void mensajeAsociado(String mensaje);

    void actualizarEstadoAmb(String estado);

    void mensajeOperarioAmbulancia(String mensaje);

    void setearOpeario(Operario operario);

    void setearListas(ArrayList<Asociado> lista);

    public int getNumAsociados();

    public int getNumSolicitudes();

    public String getNombreAsociado();

    public String getApellidoAsociado();

    public String getDNIAsociado();

    public String getCalleAsociado();

    public int getNumeroAsociado();

    public String getCiudadAsociado();

    public String getTelefonoAsociado();

    public void desactivarTaller();

    public void activarTaller();

    void mostrarError(String mensaje);

    void limpiarTextAreas();

    void setVisible(boolean b);

    void finalizarSimulacion();

    void iniciarSimulacion();

}
