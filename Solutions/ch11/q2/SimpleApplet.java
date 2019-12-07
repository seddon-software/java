package ch11.q2;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class SimpleApplet extends JApplet {
  private StringBuffer theMessage = new StringBuffer("");;
  private int x;
  private int y;
  
  public void init() {
    addMouseListener(new MouseAdapter()
    {     
      public void mousePressed(MouseEvent e) 
      {
        x = e.getX(); 
        y = e.getY();
        repaint();
      }
    }
    ); 

    showStatus(theMessage.toString());
    repaint();
  }

  public void start() {
    theMessage.append("start\n");
    showStatus(theMessage.toString());
    repaint();
  }

  public void stop() {
    theMessage.append("stop\n");
    showStatus(theMessage.toString());
    repaint();
  }

  public void destroy() {
    theMessage.append("destroy\n");
    showStatus(theMessage.toString());
    repaint();
  }

  public void paint(Graphics g) {
    g.drawString(theMessage.toString(), 10, 60);
    showStatus(theMessage.toString());
  }
}
