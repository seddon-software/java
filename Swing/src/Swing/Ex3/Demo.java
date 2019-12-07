

//Demo.java 



package Swing.Ex3;

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


public class Demo {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    pool.execute(new MyStuff());
  }
}

class MyStuff implements Runnable {

  private final int panels = 5;
  private final int rows = 4;
  private final int cols = 3;

  public void run() {

    // define components
    JFrame frame = new JFrame("Ex3");
    frame.setLayout(new FlowLayout());
    JPanel[]  panel  = new JPanel[panels];    
    JButton[] button = new JButton[panels * rows * cols];
    JLabel[]  label  = new JLabel[panels * rows * cols];

    for(int i = 0; i < panel.length; i++) {
      panel[i] = new JPanel(new GridLayout(rows,cols));
      frame.getContentPane().add(panel[i]);
    }

    for(int i = 0; i < button.length; i++) {
      int panelNo = i / (rows * cols);   
      button[i] = new JButton("" +  i);
      panel[panelNo].add(button[i]);
      label[i] = new JLabel("");
      panel[panelNo].add(label[i]);
      button[i].addActionListener(new MyListener(label[i]));
    }

    // pack and display
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}

//set up listener
class MyListener implements ActionListener {

  private JLabel label;

  public MyListener(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent e) {
    String text = label.getText();
    if(!text.equals("click"))
      label.setText("click");
    else
      label.setText("");
  }
}
