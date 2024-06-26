/*
 * Student Name: Ayan Satani
 * Student Number: 041089567
 */

import java.io.*;
import java.net.*;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			// Create a server socket listening on port 1254
			ServerSocket serverSocket = new ServerSocket(1254);
			System.out.println("Server is listening on port 1254");

			// Keep the server running
			while (true) {
				// Accept incoming client connections
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connection established with " + clientSocket.getInetAddress().getHostAddress());

				// Create input and output streams to communicate with the client
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

				String message;
				do {
					// Read messages from the client
					message = reader.readLine();
					System.out.println("Received: " + message);

					String sendMessage = message;

					writer.println(sendMessage);

				} while (!message.equalsIgnoreCase("finish"));

				// Close the streams and the client socket
				reader.close();
				writer.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
