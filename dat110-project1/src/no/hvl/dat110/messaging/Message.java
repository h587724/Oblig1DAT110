package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;
	/* Since we are given 128 bytes and 1 byte is always used for payload identification
	*/
	public Message(byte[] payload) {
		if (payload.length < 128) {
			this.payload = payload; // TODO: check for length within boundary
		} else {
			byte [] payload2 = new byte [127];
			for (int i = 0; i < payload2.length; i++) {
				payload2[i] = payload[i];
			}
			this.payload = payload2;
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		byte[] encapsulated = new byte[128];
		if (payload.length > 128) {
			return null;
		} else {
			encapsulated[0] = (byte) payload.length;
			for (int i = 0; i < payload.length; i++) {
					encapsulated[i+1] = payload[i];
			}
			return encapsulated;
		}
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
	}

	public void decapsulate(byte[] received) {
		int counter = 0;
		byte[] decapsulated = new byte [received.length - 1];
		for (int i = 0; i < received.length - 1; i++) {
			if (received[i+1] != 0) {
				counter++;
				decapsulated [i] = received[i+1];
			}
		}
		if (counter > 1) {
			this.payload = Arrays.copyOfRange(decapsulated, 0, counter);
		} else {
			payload = new byte [0];
			}
		}
		//this.payload = Arrays.copyOfRange(received, 1, received.length);
		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
}
