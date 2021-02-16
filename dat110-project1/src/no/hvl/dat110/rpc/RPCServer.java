package no.hvl.dat110.rpc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessagingServer;

public class RPCServer {

	private MessagingServer msgserver;
	private Connection connection;
	
	// hashmap to register RPC methods which are required to implement RPCImpl
	
	private HashMap<Integer,RPCImpl> services;
	
	public RPCServer(int port) {
		
		this.msgserver = new MessagingServer(port);
		this.services = new HashMap<Integer,RPCImpl>();
		
		// the stop RPC methods is built into the server
		services.put((int)RPCCommon.RPIDSTOP,new RPCServerStopImpl());
	}
	
	public void run() throws IOException {
		
		System.out.println("RPC SERVER RUN - Services: " + services.size());
		
		connection = msgserver.accept();
		
		System.out.println("RPC SERVER ACCEPTED");
		
		boolean stop = false;
		
		while (!stop) {
			Message a = connection.receive();
			
			byte [] received = a.getData();
			byte id = received[0];
			int rpcid = id;
			RPCImpl procedure = services.get(rpcid);
			assert procedure != null;
			byte [] reply = procedure.invoke(received);
			connection.send(new Message(reply));
			/*
			String unmarshalled = RPCUtils.unmarshallString(a.getData());
			byte id = unmarshalled.getBytes()[0];
			int rpcid = id;
			RPCImpl procedure = services.get(rpcid);
			assert procedure != null : "The given key is invalid!";
			byte [] reply = procedure.invoke(a.getData());
			connection.send(new Message(reply));
			*/
		   // TODO
		   // - receive message containing RPC request
		   // - find the identifier for the RPC methods to invoke
		   // - lookup the method to be invoked
		   // - invoke the method
		   // - send back message containing RPC reply
			
		   if (rpcid == RPCCommon.RPIDSTOP) {
			   stop = true;
		   }
		}
		stop();
	}
	
	public void register(int rpcid, RPCImpl impl) {
		services.put(rpcid, impl);
	}
	
	public void stop() {
		connection.close();
		msgserver.stop();
		
	}
}
