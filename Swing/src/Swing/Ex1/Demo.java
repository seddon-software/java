

//Demo.java	



package Swing.Ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Demo {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    pool.execute(new MyStuff());
  }

}

class MyStuff implements Runnable {
  public void run() {
    //Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);

    //Create and set up the window.
    JFrame frame = new JFrame("HelloWorldSwing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add the ubiquitous "Hello World" label.
    JLabel label = new JLabel("Hello World");
    frame.getContentPane().add(label);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
}
