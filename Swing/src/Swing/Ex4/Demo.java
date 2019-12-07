

//Demo.java 



package Swing.Ex4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Demo {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    pool.execute(new MyStuff());
  }
}

class MyStuff implements Runnable {

  public void run() {

    // define components
    JFrame frame = new JFrame("Ex4");
    frame.setLayout(new BorderLayout());
    JPanel panelA  = new JPanel(new FlowLayout());    
    JPanel panelB  = new JPanel(new FlowLayout());        
    frame.getContentPane().add(panelA, BorderLayout.NORTH);
    frame.getContentPane().add(panelB, BorderLayout.SOUTH);
    JButton button = new JButton("convert");
    JTextField textField = new JTextField(10);
    JLabel label = new JLabel(" ");
    panelA.add(button);
    panelA.add(textField);
    panelB.add(label);

    // registration
    button.addActionListener(new MyListener(textField, label));

    // pack and display
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}

//set up listener
class MyListener implements ActionListener {

  private JLabel label;
  private JTextField textField;

  public MyListener(JTextField textField, JLabel label) {
    this.label = label;
    this.textField = textField; 
  }

  public void actionPerformed(ActionEvent e) {
    label.setText(textField.getText());
  }
}
