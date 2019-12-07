package ch11.q3;

import java.awt.*;
import javax.swing.*;

public class PieApplet extends JApplet {
  private int x, y;
  private Color colour;

  public void init() {
    try {
      setSize(new Dimension(400,300));
      x = 150;
      y = 100;
      changeColour();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  void changeColour() {
    float red   = (float) Math.random();
    float green = (float) Math.random();
    float blue  = (float) Math.random();
    colour = new Color(red, green, blue);
    repaint();
  }

  public void start() {
    changeColour();
  }

  public void paint(Graphics g) {
    changeColour(); 
    g.setColor(colour);
    g.fillArc(x, y, 50, 50, 0, 270);
  }
}
