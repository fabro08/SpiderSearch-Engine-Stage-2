package Sockets;

import java.net.*;
import java.io.*;

/**
 * 
 *
 * 
 * @author Jorge V
 */

public class Cliente {

	final String HOST = "localhost";

	final int PUERTO = 5000;

	Socket CreaSocket;

	DataOutputStream mensaje;

	BufferedReader entrada;
	
	String MensajeServidor;
	// Cliente

	public void initClient() /* ejecuta este metodo para correr el cliente */

	{

		try

		{

			 CreaSocket = new Socket("localhost", 5008); /*
											 * conectar a un servidor en
											 * localhost con puerto 5000
											 */

			// creamos el flujo de datos por el que se enviara un mensaje

			mensaje = new DataOutputStream(CreaSocket.getOutputStream());
			entrada = new BufferedReader(new InputStreamReader(CreaSocket.getInputStream()));
			 MensajeServidor = entrada.readLine();
			 System.out.println(MensajeServidor);

			// enviamos el mensaje

			mensaje.writeUTF("hola que tal!!");
			System.out.println("a");

			// cerramos la conexión

		//	sc.close();

		} catch (Exception e)

		{

			System.out.println("Error: " + e.getMessage());

		}

	}

}
