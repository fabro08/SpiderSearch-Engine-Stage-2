package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaConfiguracion extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textoIp;
	private JLabel textoPuerto;
	private JTextField cajaIp;
	private JTextField cajaPuerto;
	private JButton boton;
	private String ip;
	private int puerto;

	public VentanaConfiguracion() {
		super();
		ConfiguracionVentana();
		ComponentesVentana();
	}

	private void ConfiguracionVentana() {
		this.setTitle("​Configuración");
		this.setSize(640, 410);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void ComponentesVentana() {
		// creamos los componentes
		textoIp = new JLabel();
		textoPuerto = new JLabel();
		cajaIp = new JTextField();
		cajaPuerto = new JTextField();
		boton = new JButton();
		// configuramos los componentes
		textoIp.setText("Cambiar dirección IP");
		textoIp.setBounds(250, 100, 250, 25);
		cajaIp.setBounds(220, 125, 200, 25);
		
		textoPuerto.setText("Cambiar Puerto");
		textoPuerto.setBounds(260, 175, 250, 25);
		cajaPuerto.setBounds(285, 200, 50, 25);
		boton.setText("Guardar");
		boton.setBounds(260, 250, 100, 30);
		boton.addActionListener(this);
		// adicionamos los componentes a la ventana
		this.add(textoIp);
		this.add(textoPuerto);
		this.add(cajaIp);
		this.add(cajaPuerto);
		this.add(boton);
		
		 	}
	public void actionPerformed(ActionEvent e) {
		try{
		ip = cajaIp.getText();
		
		puerto = Integer.parseInt(cajaPuerto.getText());
		
		VentanaCliente aCliente = new VentanaCliente(ip,puerto);
		aCliente.setVisible(true);
		
		this.pack();
		
		}
		catch(Exception b){
			JOptionPane.showMessageDialog(this,"Error, por favor revisar los datos" );
		}
	}
}