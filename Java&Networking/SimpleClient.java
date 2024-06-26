/*
 * Student Name: Ayan Satani
 * Student Number: 041089567
 */

import java.io.*;
import java.net.*;

public class SimpleClient {
	public static void main(String[] args) {
		try {
			// Create a socket and connect to the server running on localhost at port 1254
			Socket clientSocket = new Socket("localhost", 1254);
			System.out.println("Connected to server");

			// Create input to read user input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// Create output to send data to the server
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

			String message;
			do {
				// Prompt the user to enter a message
				System.out.print("Enter a message to send (type 'finish' to exit the program): ");
				message = reader.readLine();
				// Send the user's message to the server
				writer.println(message);

				BufferedReader serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String serverMessage = serverReader.readLine();
			} while (!message.equalsIgnoreCase("finish"));

			// Close the input stream, output stream, and the client socket
			reader.close();
			writer.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
