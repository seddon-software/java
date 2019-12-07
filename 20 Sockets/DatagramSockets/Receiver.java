////////////////////////////////////////////////////////////
//
//    Receiver
//
////////////////////////////////////////////////////////////

package DatagramSockets;


import java.io.*;
import java.net.*;


public class Receiver {
  
  public final static int MAX_PACKET_SIZE = 65535 - 20 - 8;
  private String url = "localhost";
  private int port = 10013;
  private byte buffer[];

  public static void main(String[] args) {
    Receiver receiver = new Receiver();
    receiver.receiveDatagram();
  }

  public Receiver() {
    buffer = new byte[MAX_PACKET_SIZE];
    for(int i = 0; i < MAX_PACKET_SIZE; i++) {
      buffer[i] = 0;
    }
  }
  
  public void receiveDatagram() {
    DatagramSocket receiver = null;
    try {
      receiver = new DatagramSocket(port);
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      
      while(true) {
        receiver.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        InetAddress senderAddress = packet.getAddress();
        String senderHostname = senderAddress.getCanonicalHostName();
        int senderPort = packet.getPort();
        
        System.out.println("sender message: " + message);
        if(message.equalsIgnoreCase("QUIT")) break;
        
        // reset for next packet
        packet.setLength(buffer.length);
      }
    } catch(UnknownHostException e) {
      System.err.println(e);
    } catch(IOException e) {
      System.err.println(e);
    }
    receiver.disconnect();
  }
}