package com.gugawag.so.ipc;

/**
 * Client program requesting current date from server.
 *
 * Figure 3.22
 *
 * @author Silberschatz, Gagne and Galvin. Pequenas alterações feitas por Gustavo Wagner (gugawag@gmail.com)
 * Operating System Concepts  - Eighth Edition
 */ 

import java.io.*;
import java.net.*;

public class DateClient {
	public static void main(String[] args)  {
		try {
			// this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("10.0.72.75",6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));

			System.out.println("=== Cliente iniciado ===\n");

			String line = bin.readLine();
			System.out.println("O servidor me disse:" + line);
			System.out.println("Pedro Gimenes Bravim");
				
			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
