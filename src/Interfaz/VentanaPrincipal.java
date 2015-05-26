package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JLabel texto;
	private JTextField caja;
	private JButton boton;

	public VentanaPrincipal() {
		super();
		ConfiguracionVentana();
		ComponentesVentana();
	}

	private void ConfiguracionVentana() {
		this.setTitle("​SpiderSearch Engine: Stage 2");
		this.setSize(640, 410);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}

	private void ComponentesVentana() {
		// creamos los componentes
		texto = new JLabel();
		caja = new JTextField();
		boton = new JButton();
		// configuramos los componentes
		texto.setText("Inserte el texto a buscar");
		texto.setBounds(215, 125, 250, 25);
		caja.setBounds(180, 160, 250, 25);
		boton.setText("Search");
		boton.setBounds(200, 200, 200, 30);
		boton.addActionListener(this);
		// adicionamos los componentes a la ventana
		this.add(texto);
		this.add(caja);
		this.add(boton);
	}
	public void actionPerformed(ActionEvent e) {

		String nombre = caja.getText();
		if(nombre.equals("a")){
			System.out.println("sí");
		}
		else{
			System.out.println("no");
		}
	//	System.out.println(caja.getText());
		
	        
		// JOptionPane.showMessageDialog(this, "Hola " + nombre + "."); }
	}
	public String getTexto(){
		return caja.getText();
		
	}
}