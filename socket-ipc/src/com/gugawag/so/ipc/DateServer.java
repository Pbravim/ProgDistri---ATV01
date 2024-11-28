package com.gugawag.so.ipc;

/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.21
 *
 * @author Silberschatz, Gagne, and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013.
 */
import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer{
	public static void main(String[] args)  {
		try {
			ServerSocket sock = new ServerSocket(6013);

			System.out.println("=== Servidor iniciado ===\n");
			System.out.println("Pedro Gimenes Bravim");
			// escutando por conexões
			while (true) {
				Socket client = sock.accept();
				Thread thread = new Thread(() -> {
					try {
						// DataOutputStream dos = new DataOutputStream(client.getOutputStream());
						// DataInputStream dis = new DataInputStream(client.getInputStream());

						System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort()); 
						
						PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

						pout.println(new Date().toString() + "-Boa noite alunos!");

						InputStream in = client.getInputStream();
						BufferedReader bin = new BufferedReader(new InputStreamReader(in));

						String line = bin.readLine();
						System.out.println("O cliente me disse:" + line);
					
						// client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});				
				thread.start();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
