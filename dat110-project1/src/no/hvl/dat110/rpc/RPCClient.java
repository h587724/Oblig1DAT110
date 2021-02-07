package no.hvl.dat110.rpc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() throws UnknownHostException, IOException {
		Connection c = msgclient.connect();
		this.connection = c;
		
		// TODO: connect using the underlying messaging layer connection
	}
	
	public void disconnect() {
		connection.close();
		this.connection = null;
		// TODO: disconnect/close the underlying messaging connection

		
	}
	
	public byte[] call(byte[] rpcrequest) throws IOException {
		
		connection.send(new Message(rpcrequest));
		Message received = connection.receive();
		byte[] rpcreply = received.getData();
		/* TODO: 
		
		Make a remote call on the RPC server by sending the RPC request message
		and receive an RPC reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		return rpcreply;
		
	}

}
