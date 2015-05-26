package Sockets;

import java.net.*;
import java.io.*;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

/**
 * 
 *
 * 
 * @author Jorge V
 */

public class Servidor {

	int puerto = 5008;

	ServerSocket Conexion;

	Socket CreaSocket;

	DataOutputStream salida;

	String MensajeCliente;

	// SERVIDOR

	public void initServer() {
		BufferedReader entrada;

		try {
			Conexion = new ServerSocket(puerto);
			CreaSocket = new Socket();
			System.out.println("Esperando conexion:");
			
			CreaSocket = Conexion.accept();

			// Inicia el socket, ahora esta esperando una conexión por parte del
			// cliente

			System.out.println("Un cliente se ha conectado.");

			// Canales de entrada y salida de datos

			entrada = new BufferedReader(new InputStreamReader(CreaSocket.getInputStream()));

			salida = new DataOutputStream(CreaSocket.getOutputStream());

			System.out.println("Confirmando conexion al cliente");

			salida.writeUTF("Conexión exitosa");

			// Recepcion de mensaje

			MensajeCliente = entrada.readLine();
			

			System.out.println(MensajeCliente);

			salida.writeUTF("Se recibio tu mensaje ");

			System.out.println("Cerrando conexión...");


			Conexion.close();// Aqui se cierra la conexión con el cliente

		} catch (Exception e)

		{

			System.out.println("Se ha producido el siguiente error: " + e.getMessage());

		}
	}
	public String GetMensaje(){
		return MensajeCliente;
	}

}