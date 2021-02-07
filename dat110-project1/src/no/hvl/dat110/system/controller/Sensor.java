package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() throws IOException {
		
		byte [] request = RPCUtils.marshallVoid(RPCID);
		byte [] response = rpcclient.call(request);

		int temp = RPCUtils.unmarshallInteger(response);
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		
		return temp;
	}
	
}
