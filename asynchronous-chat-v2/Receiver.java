import java.util.Scanner;
import java.net.*;
import java.io.*;

/*

	Receiver accepts messages going from client to server.

*/

class Receiver extends Thread {

	private Socket server;
	private ChatMessage new_msg;
	private boolean received_message = false;
	private volatile boolean stopped = false;

	// constructors
	public Receiver() {}

	public Receiver(Socket s) {
		this.server = s;
	}

	// getters and setters
	public void set_received_message(boolean r) { this.received_message = r; }

	public ChatMessage receive_message(Socket s) {		

		// System.out.println("halp");

		try {

			String sender_addr = s.getRemoteSocketAddress().toString();

			DataInputStream in = new DataInputStream(s.getInputStream());
			String sender_message = in.readUTF();

			System.out.println(sender_message);
	
			new_msg = new ChatMessage(sender_addr, sender_message);
			set_received_message(true);


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("receiving!!");
		}

		return new_msg;

	}

	public void stop_receiving() {
		System.out.println("stopping...");
		this.stopped = true;
	}

	public void run() {
		// System.out.println("receiver thread");
		// while (true) {

		// 	ChatMessage cm = this.receive_message(this.server);

		// 	if (cm.message.equals("bye")) {
				this.stop_receiving();
		// 	}
			
		// }
	}

}