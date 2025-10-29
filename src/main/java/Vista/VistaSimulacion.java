package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.SpringLayout;

public class VistaSimulacion extends JFrame implements DocumentListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JTabbedPane pestana; 
	private JPanel contentPane;
	private JPanel PanelABM;
	private JScrollPane panelListadoAsoc;
	private JList listAsociados;
	private JPanel panelInfoAsoc;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField textFieldNombre;

	private JTextField textFieldApellido;

	private JTextField textFieldDNI;

	private JTextField textFieldCalle;

	private JTextField textFieldNumero;

	private JTextField textFieldTelefono;

	private JTextField textFieldCiudad;
	private JPanel panel_7;
	private JPanel panelABM;
	private JPanel panelManejoSim;
	private JPanel panel_8;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificacion;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panelInfoSim;
	private JTextArea textAsociados;
	private JPanel panelCondicionesSim;
	private JPanel panelNumAsociados;
	private JPanel panelAcciones;
	private JLabel lblNroAsociados;
	private JTextField textFieldNumAsociados;
	private JLabel lblNroSolicitudes;
	private JTextField textFieldNumSolicitudes;
	private JPanel panel_9;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JButton btnReiniciarSim;
	private JButton btnFinalizarSim;
	private JPanel panel_18;
	private JPanel panel_19;
	private JButton btnReiniciarDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSimulacion frame = new VistaSimulacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaSimulacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		
		JTabbedPane tabbedPane = new JTabbedPane();
        setContentPane(tabbedPane);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
        tabbedPane.addTab("Manejo Asociados", contentPane);
        
        JPanel panelAdmAmbulancia = new JPanel();
        panelAdmAmbulancia.setLayout(new BorderLayout());
        tabbedPane.addTab("Administración Ambulancia", panelAdmAmbulancia);
		
		this.PanelABM = new JPanel();
		this.contentPane.add(this.PanelABM, BorderLayout.CENTER);
		this.PanelABM.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_7 = new JPanel();
		this.PanelABM.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panelInfoAsoc = new JPanel(new GridLayout(7, 2, 10, 5));
		this.panelInfoAsoc.setBorder(new TitledBorder(null, "Informacion Asociado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_7.add(this.panelInfoAsoc);

		this.panelInfoAsoc.add(new JLabel("Nombre"));
		this.textFieldNombre = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldNombre);

		this.panelInfoAsoc.add(new JLabel("Apellido"));
		this.textFieldApellido = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldApellido);

		this.panelInfoAsoc.add(new JLabel("DNI"));
		this.textFieldDNI = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldDNI);

		this.panelInfoAsoc.add(new JLabel("Calle"));
		this.textFieldCalle = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldCalle);

		this.panelInfoAsoc.add(new JLabel("Número"));
		this.textFieldNumero = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldNumero);

		this.panelInfoAsoc.add(new JLabel("Teléfono"));
		this.textFieldTelefono = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldTelefono);

		this.panelInfoAsoc.add(new JLabel("Ciudad"));
		this.textFieldCiudad = new JTextField(10);
		this.panelInfoAsoc.add(this.textFieldCiudad);
		
		this.panelABM = new JPanel();
		this.panel_7.add(this.panelABM);
		this.panelABM.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panel_8 = new JPanel();
		this.panel_8.setBorder(new TitledBorder(null, "ABM Asociados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelABM.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_10 = new JPanel();
		this.panel_8.add(this.panel_10);
		
		this.btnAlta = new JButton("Alta de Asociado");
		this.btnAlta.setEnabled(false);
		this.btnAlta.setBackground(new Color(128, 255, 128));
		this.panel_10.add(this.btnAlta);
		
		this.panel_11 = new JPanel();
		this.panel_8.add(this.panel_11);
		
		this.btnBaja = new JButton("Baja de Asociado");
		this.btnBaja.setEnabled(false);
		this.btnBaja.setBackground(new Color(255, 128, 128));
		this.panel_11.add(this.btnBaja);
		
		this.panel_12 = new JPanel();
		this.panel_8.add(this.panel_12);
		
		this.btnModificacion = new JButton("Modificacion de Asociado");
		this.btnModificacion.setEnabled(false);
		this.btnModificacion.setBackground(new Color(255, 255, 128));
		this.panel_12.add(this.btnModificacion);
		
		this.panelManejoSim = new JPanel();
		this.PanelABM.add(this.panelManejoSim);
		this.panelManejoSim.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panelInfoSim = new JPanel();
		this.panelInfoSim.setBorder(new TitledBorder(null, "Informacion Movimientos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelManejoSim.add(this.panelInfoSim);
		this.panelInfoSim.setLayout(new BorderLayout(0, 0));
		
		this.textAsociados = new JTextArea();
		this.textAsociados.setEditable(false);
		this.panelInfoSim.add(this.textAsociados);
		
		this.panelCondicionesSim = new JPanel();
		this.panelManejoSim.add(this.panelCondicionesSim);
		this.panelCondicionesSim.setLayout(new GridLayout(2, 0, 10, 5));
		
		this.panelNumAsociados = new JPanel();
		this.panelNumAsociados.setBorder(new TitledBorder(null, "Condiciones Simulacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCondicionesSim.add(this.panelNumAsociados);
		this.panelNumAsociados.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_13 = new JPanel();
		this.panelNumAsociados.add(this.panel_13);
		
		this.lblNroAsociados = new JLabel("Nº de Asociados");
		this.panel_13.add(this.lblNroAsociados);
		
		this.panel_9 = new JPanel();
		this.panelNumAsociados.add(this.panel_9);
		
		this.textFieldNumAsociados = new JTextField();
		this.panel_9.add(this.textFieldNumAsociados);
		this.textFieldNumAsociados.setColumns(10);
		
		this.panel_14 = new JPanel();
		this.panelNumAsociados.add(this.panel_14);
		
		this.lblNroSolicitudes = new JLabel("Nº de Solicitudes");
		this.panel_14.add(this.lblNroSolicitudes);
		
		this.panel_15 = new JPanel();
		this.panelNumAsociados.add(this.panel_15);
		
		this.textFieldNumSolicitudes = new JTextField();
		this.panel_15.add(this.textFieldNumSolicitudes);
		this.textFieldNumSolicitudes.setColumns(10);
		
		this.panelAcciones = new JPanel();
		this.panelCondicionesSim.add(this.panelAcciones);
		this.panelAcciones.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_16 = new JPanel();
		this.panel_16.setBorder(new TitledBorder(null, "Simulacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelAcciones.add(this.panel_16);
		this.panel_16.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_18 = new JPanel();
		this.panel_16.add(this.panel_18);
		
		this.btnReiniciarSim = new JButton("Reiniciar");
		this.btnReiniciarSim.setEnabled(false);
		this.btnReiniciarSim.setBackground(new Color(255, 128, 128));
		this.panel_18.add(this.btnReiniciarSim);
		
		this.panel_19 = new JPanel();
		this.panel_16.add(this.panel_19);
		
		this.btnFinalizarSim = new JButton("Finalizar");
		this.btnFinalizarSim.setBackground(new Color(255, 128, 128));
		this.panel_19.add(this.btnFinalizarSim);
		
		this.panel_17 = new JPanel();
		this.panel_17.setBorder(new TitledBorder(null, "Reiniciar Base de Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelAcciones.add(this.panel_17);
		
		this.btnReiniciarDB = new JButton("Reiniciar BD");
		this.btnReiniciarDB.setBackground(new Color(255, 0, 0));
		this.panel_17.add(this.btnReiniciarDB);
		
		this.panelListadoAsoc = new JScrollPane();
		this.panelListadoAsoc.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lista de Asociados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(this.panelListadoAsoc, BorderLayout.WEST);
		this.panelListadoAsoc.setPreferredSize(new Dimension(150,300));
		
		this.listAsociados = new JList();
		this.listAsociados.setBorder(null);
		this.panelListadoAsoc.setViewportView(this.listAsociados);
		
		agregarListenerAsociados(textFieldNombre);
		agregarListenerAsociados(textFieldApellido);
		agregarListenerAsociados(textFieldCalle);
		agregarListenerAsociados(textFieldNumero);
		agregarListenerAsociados(textFieldCiudad);
		agregarListenerAsociados(textFieldTelefono);
		agregarListenerAsociados(textFieldDNI);
		
		agregarListenerSimulacion(textFieldNumAsociados); 
		agregarListenerSimulacion(textFieldNumSolicitudes);
		

	}

	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}
	
	private void agregarListenerAsociados(JTextField campo) {
		
	    campo.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            validarCamposAsociados();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            validarCamposAsociados();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            validarCamposAsociados();
	        }
	    });
	}
	
	private void agregarListenerSimulacion(JTextField campo) {
	    campo.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            validarCamposSimulacion();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            validarCamposSimulacion();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            validarCamposSimulacion();
	        }
	    });
	}
	

	private void validarCamposAsociados() {
	    
	    String nombre = textFieldNombre.getText().trim();
	    String apellido = textFieldApellido.getText().trim();
	    String calle = textFieldCalle.getText().trim();
	    String numeroStr = textFieldNumero.getText().trim();
	    String ciudad = textFieldCiudad.getText().trim();
	    String telefono = textFieldTelefono.getText().trim();
	    String dni = textFieldDNI.getText().trim();

	    boolean valido = true;

	    if(nombre.isEmpty() || apellido.isEmpty() || calle.isEmpty() || ciudad.isEmpty()) {
	        valido = false;
	    }
	    
	    try {
	        int numero = Integer.parseInt(numeroStr);
	        if(numero <= 0) valido = false;
	    } catch(NumberFormatException e) {
	        valido = false;
	    }

	    if(!telefono.matches("\\d{7}")) {
	        valido = false;
	    }

	    if(!dni.matches("\\d{1,8}")) {
	        valido = false;
	    }

	    btnAlta.setEnabled(valido);
	    btnBaja.setEnabled(valido);
	    btnModificacion.setEnabled(valido);
	}
	
	private void validarCamposSimulacion() {
	    String numAsociadosStr = textFieldNumAsociados.getText().trim();
	    String numSolicitudesStr = textFieldNumSolicitudes.getText().trim();
	    boolean valido = true;

	    try {
	        int numAsociados = Integer.parseInt(numAsociadosStr);
	        if (numAsociados <= 0) valido = false;
	    } catch (NumberFormatException e) {
	        valido = false;
	    }

	    try {
	        int numSolicitudes = Integer.parseInt(numSolicitudesStr);
	        if (numSolicitudes < 0) valido = false;
	    } catch (NumberFormatException e) {
	        valido = false;
	    }

	    btnReiniciarSim.setEnabled(valido);
	}	
	
	
}
