

//Demo.java 



package Swing.Ex2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demo {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    pool.execute(new MyStuff());
  }
}

class MyStuff implements Runnable {
  public void run() {
    // define look and feel
    JFrame.setDefaultLookAndFeelDecorated(true);

    // define components
    JFrame frame = new JFrame("HelloWorldSwing");
    JPanel panel = new JPanel(new GridLayout(2,1));
    JLabel label = new JLabel("Messages appear here ...");
    JButton theButton = new JButton("click");

    // registration
    theButton.addActionListener(new MyListener(label));

    // add widgets
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    panel.add(theButton);    
    panel.add(label);

    // pack and display
    frame.pack();
    frame.setVisible(true);
  }
}

// set up listener
class MyListener implements ActionListener {

  private JLabel label;

  public MyListener(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    label.setText("click");    
  }
}
