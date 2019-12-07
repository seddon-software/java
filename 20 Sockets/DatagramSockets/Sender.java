////////////////////////////////////////////////////////////
//
//    Sender
//
////////////////////////////////////////////////////////////

package DatagramSockets;


import java.io.*;
import java.net.*;


public class Sender {
  
  public final static int MAX_PACKET_SIZE = 65535 - 20 - 8;
  private String url = "localhost";
  private int senderPort = 10012;
  private int receiverPort = 10013;

  public static void main(String[] args) {
    Sender sender = new Sender();
    sender.sendDatagram();
  }

  public byte[] GetData() {
    String message = "";
    try {
      BufferedReader in =
        new BufferedReader(
                new InputStreamReader(System.in));
      message = in.readLine();
    } catch(IOException e) {
      System.err.println(e);      
    }
    return message.getBytes();
  }
  
  public void sendDatagram() {
    try {
      System.out.println("Enter lines of text ('quit') to finish");
      InetAddress receiver = InetAddress.getByName(url);
      DatagramSocket sender = new DatagramSocket(senderPort);
      
      while(true) {
        byte buffer[] = new byte[MAX_PACKET_SIZE];
        buffer = GetData();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiver, receiverPort);
        sender.send(packet);
        if((new String(buffer)).equalsIgnoreCase("QUIT")) break;
      }
    } catch(UnknownHostException e) {
      System.err.println(e);
    } catch(IOException e) {
      System.err.println(e);
    }
  }
}