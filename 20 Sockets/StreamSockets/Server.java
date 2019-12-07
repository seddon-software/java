////////////////////////////////////////////////////////////
//
//    Server
//
////////////////////////////////////////////////////////////

package StreamSockets;

import java.net.*;
import java.io.*;

public class Server {
	private static String hostname = "localhost";
	private static int port = 8001;
	private static InetAddress serverAddress;

	public static void main(String[] args) {
		System.out.println(
			"This is the server, clients enter lines of text ('quit' to finish)");
		try {
			ServerSocket listener = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress(hostname, port);
			listener.bind(address, 5);

			while (true) {
				Socket comms = listener.accept();
				CommsThread commsThread = new CommsThread(comms);
				commsThread.start();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}

class CommsThread extends Thread {

	private InputStreamReader in;
	private char[] message = new char[101];

	public CommsThread(Socket socket) {
		try {
			in = new InputStreamReader(socket.getInputStream());
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void run() {
		int bytesRead;
		try {
			while (true) {
				bytesRead = in.read(message, 0, 100);
				if (bytesRead == -1) {
					in.close();
					break;
				} else {
					String s = new String(message, 0, bytesRead);
					System.out.println(s);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
