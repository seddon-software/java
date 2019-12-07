////////////////////////////////////////////////////////////
//
//    Thread pipes
//
////////////////////////////////////////////////////////////

package InterThreadCommunication.Pipes;

import java.io.*;

public class Test {
  public static void main(String[] args) {
    try {
      final PipedOutputStream pipeOut = new PipedOutputStream();
      Runnable runnable = new Runnable() {
        public void run () {
          try {
            PipedInputStream pipeIn = new PipedInputStream(pipeOut);
            System.out.println(pipeIn.read()); // read and process data
            System.out.println(pipeIn.read());
            System.out.println(pipeIn.read());
            System.out.println(pipeIn.read());
            pipeIn.close();
          } catch(IOException e) {
            System.err.println(e);
          }
        }
      };
      new Thread(runnable).start();
      Thread.yield();
      pipeOut.write(10);			// write data to pipe
      pipeOut.write(20);
      pipeOut.write(30);
      pipeOut.write(40);
      pipeOut.close();
    } catch(Exception e) {
      System.err.println(e);
    }
  }
}


