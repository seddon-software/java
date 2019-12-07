package ch12.q1;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class TestPie extends JApplet implements ActionListener {
  private static final long serialVersionUID = 1L;
  private Container container;
  private JButton leftButton, rightButton;
  private int x, y;

  public void init() {
    try {
      setSize(new Dimension(400,300));
      x = 150;
      y = 100;
      container = getContentPane();
      container.setLayout(new FlowLayout());
      leftButton = new JButton("left");
      rightButton = new JButton("right");
      container.add(leftButton);
      container.add(rightButton);

      leftButton.addActionListener(this);
      rightButton.addActionListener(this);
    } catch(Exception e) { e.printStackTrace(); }
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == leftButton)  Move(-10);
    if (event.getSource() == rightButton) Move(+10);
    repaint();
  }

  public void Move(int dx) {
    x += dx;
  }

  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.blue);
    g.fillArc(x, y, 50, 50, 0, 270);
  }
}