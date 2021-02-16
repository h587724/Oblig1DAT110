package no.hvl.dat110.system.controller;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write (String i) throws IOException {

		byte [] marshalled = RPCUtils.marshallString(RPCID, i);
		rpcclient.call(marshalled);
		RPCUtils.unmarshallVoid(marshalled);
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method

		
	}
}
