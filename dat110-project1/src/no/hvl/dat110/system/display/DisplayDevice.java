package no.hvl.dat110.system.display;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Display server starting ...");
		
		// TODO
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		DisplayImpl implementation = new DisplayImpl();
		RPCServer rpcserver = new RPCServer(Common.DISPLAYPORT);
		rpcserver.register(1, implementation);
		rpcserver.run();
		rpcserver.stop();
		
		System.out.println("Display server stopping ...");
		
	}
}
