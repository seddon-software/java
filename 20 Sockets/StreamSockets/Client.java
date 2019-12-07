////////////////////////////////////////////////////////////
//
//    Client
//
////////////////////////////////////////////////////////////

package StreamSockets;


import java.io.*;
import java.net.*;


public class Client extends Thread {
  
  private String id;
  private String hostname = "localhost";
  private int port = 8001;
  private OutputStreamWriter out;

  public static void main(String[] args) {
    Client client = new Client(args[0]);
    client.start();
  }

  public Client(String id) {
    this.id = id + ": ";
  }
  
  public void ReadDataAndSend() throws IOException {
    while(true)
    {
      BufferedReader in =
        new BufferedReader(
                new InputStreamReader(System.in));
      String message = in.readLine();
      if(message.equalsIgnoreCase("QUIT")) break;
      out.write(id + message);
      out.flush();
    }
  }

  public void run() {
    try {
      Socket theSocket = new Socket();
      InetSocketAddress address = new InetSocketAddress(hostname, port); 
      theSocket.connect(address);
      
      out = new OutputStreamWriter(theSocket.getOutputStream());
      ReadDataAndSend();
    } catch(UnknownHostException e) {
      System.err.println(e);
    } catch(IOException e) {
      System.err.println(e);
    }
    System.out.printf("Client %s completed\n", this.id);
  }
}