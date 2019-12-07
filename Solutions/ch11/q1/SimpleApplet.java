package ch11.q1;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class SimpleApplet extends JApplet {
  private String theMessage;

  public void init() {
    try {
      setSize(new Dimension(400,300));
      theMessage = getParameter("message");
      if (theMessage == null) theMessage = "No message";
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics g) {
    g.drawString(theMessage, 10, 60);
  }
}