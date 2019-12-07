package ch11.q4;

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.net.*;

public class Rabbit extends JApplet {

  private static final long serialVersionUID = 1L;
  private Image rabbit;
  private AudioClip cuckoo;

  public void init() {
    try {
      setSize(new Dimension(400,300));
      rabbit = getImage(getDocumentBase(), "rabbit.gif");
      cuckoo = getAudioClip(getDocumentBase(), "cuckoo.au");
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics g) {
    g.drawImage(rabbit, 50, 10, this);
    cuckoo.play();
  }
}