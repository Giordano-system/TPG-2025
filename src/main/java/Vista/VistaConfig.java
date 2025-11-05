package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class VistaConfig extends JFrame implements DocumentListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelConfig;
	private JPanel panelBtn;
	private JLabel lblTitulo;
	private JLabel lblNumAsociados;
	private JTextField textFieldNumAso;
	private JLabel lblNumSolicitudes;
	private JTextField textFieldNumSolicitudes;
	private JButton btnIniciarSim;
    private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaConfig frame = new VistaConfig();
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
	public VistaConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 280);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(10, 10));
		
		this.panelTitulo = new JPanel();
		this.contentPane.add(this.panelTitulo, BorderLayout.NORTH);
		
		this.lblTitulo = new JLabel("Configuracion de la Simulación de Ambulancias");
		this.lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		this.panelTitulo.add(this.lblTitulo);
		
		// Panel de campos
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 15, 15));
        panelCampos.setBorder(new EmptyBorder(20, 10, 20, 10));
        
        JLabel lblAsociados = new JLabel("Número de Asociados:");
        lblAsociados.setFont(new Font("Arial", Font.PLAIN, 13));
        panelCampos.add(lblAsociados);
        
        textFieldNumAso = new JTextField();
        agregarListenerSimulacion(textFieldNumAso);
        textFieldNumAso.setFont(new Font("Arial", Font.PLAIN, 13));
        panelCampos.add(textFieldNumAso);
        
        JLabel lblSolicitudes = new JLabel("Número de Solicitudes:");
        lblSolicitudes.setFont(new Font("Arial", Font.PLAIN, 13));
        panelCampos.add(lblSolicitudes);
        
        textFieldNumSolicitudes = new JTextField();
        agregarListenerSimulacion(textFieldNumSolicitudes);
        textFieldNumSolicitudes.setFont(new Font("Arial", Font.PLAIN, 13));
        panelCampos.add(textFieldNumSolicitudes);
        
        this.contentPane.add(panelCampos, BorderLayout.CENTER);
		this.panelBtn = new JPanel();
		this.contentPane.add(this.panelBtn, BorderLayout.SOUTH);
		
		this.btnIniciarSim = new JButton("Iniciar Simulacion");
		this.btnIniciarSim.setEnabled(false);
		this.btnIniciarSim.setBackground(new Color(176, 255, 176));
		this.btnIniciarSim.setFont(new Font("Arial", Font.BOLD, 15));
		this.panelBtn.add(this.btnIniciarSim);
		this.btnIniciarSim.setPreferredSize(new Dimension(180,35));

	}

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
        this.btnIniciarSim.addActionListener(this.actionListener);
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

    private void validarCamposSimulacion() {
        String numAsociadosStr = textFieldNumAso.getText().trim();
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

        btnIniciarSim.setEnabled(valido);
    }

    public int getNumAsociados() {
        return Integer.parseInt(this.textFieldNumAso.getText().trim());
    }

    public int getNumSolicitudes() {
        return Integer.parseInt(this.textFieldNumSolicitudes.getText().trim());
    }


    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
