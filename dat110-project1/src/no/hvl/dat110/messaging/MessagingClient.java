package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() throws UnknownHostException, IOException {
		Socket clientSocket = new Socket(server, port);
		Connection connection = new Connection(clientSocket);
		// TODO
		// create TCP socket for client and connection
		// create connection object
		return connection;
	}
}
