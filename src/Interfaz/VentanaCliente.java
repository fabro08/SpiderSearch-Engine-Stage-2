package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Sockets.Cliente;
import Sockets.Server;

/**
 * Clase utilizada para crear una ventana de cliente
 * 
 * @author fabricio
 *
 */
public class VentanaCliente extends JFrame implements ActionListener {
	// **Atributos*/
	private JLabel TextoPrincipal;
	private JTextField entradaTexto;
	private JButton BotonBuscar;
	private JButton BotonModificar;
	String Dirip;
	int Dirpuerto;

	Cliente cliente = new Cliente();

	/**
	 * Constructor
	 * 
	 * @param ip
	 *            : Direccion ip utilizada
	 * @param puerto
	 *            : Direccion puerto utilizado
	 */
	public VentanaCliente(String ip, int puerto) {
		super();
		Ventana();
		Componentes();
		Dirip = ip;
		Dirpuerto = puerto;
	}

	/**
	 * Metodo para establecer configuracion inicial
	 */
	private void Ventana() {
		this.setTitle("​SpiderSearch Engine: Stage 2: Cliente");
		this.setSize(640, 410);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * Metodo para crear los componentes
	 */
	private void Componentes() {
		/** Se crean los componentes */
		TextoPrincipal = new JLabel();
		entradaTexto = new JTextField();
		BotonBuscar = new JButton();
		BotonModificar = new JButton();

		TextoPrincipal.setText("Inserte el texto a buscar");
		TextoPrincipal.setBounds(215, 125, 250, 25);
		entradaTexto.setBounds(180, 160, 250, 25);
		BotonBuscar.setText("Search");
		BotonBuscar.setBounds(200, 200, 200, 30);
		BotonBuscar.addActionListener(this);
		BotonModificar.setText("Configuración");
		BotonModificar.setBounds(487, 345, 140, 30);
		BotonModificar.addActionListener(this);

		this.add(TextoPrincipal);
		this.add(entradaTexto);
		this.add(BotonBuscar);
		this.add(BotonModificar);

	}

	/** Al tocar un botón */
	public void actionPerformed(ActionEvent boton) {

		/** Si se presiona el boton buscar */
		if (boton.getSource() == BotonBuscar) {
			cliente.IniciarCliente(entradaTexto.getText(), Dirip, Dirpuerto);
			//VentanaResultados aResultados = new VentanaResultados();
			//aResultados.setVisible(true);
//
		}
		/** Sino */
		else {
			VentanaConfiguracion aPrincipal = new VentanaConfiguracion();
			aPrincipal.setVisible(true);

		}
		this.hide();

	}

}