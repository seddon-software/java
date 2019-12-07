package ch14.q1;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class PieApplet extends JApplet
											 implements Runnable {
	private Thread thread;
	private Color colour;
	private int stage;
	private int x, y;
	private int dx, dy;
	private boolean isActive;

  public void init() {
	    setSize(new Dimension(400,300));
			x = 100;
			y = 100;
	}

	public void start() {
		if (thread == null) {
			isActive = true;
			thread = new Thread(this);
   		thread.start();
		}
	}

	public void stop() {
		isActive = false;
	}

	public void run()
	{
    try
		{
			while (isActive)
			{
        Thread.sleep(100);
				CalculatePosition();
				repaint();
			}
    }
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
			thread = null;
  }

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(colour);
		g.fillArc(x + dx, y + dy, 75, 75, 0, 270);
	}

	private void CalculatePosition() {
		if(dx ==  0 && dy ==  0) stage = 1;
		if(dx == 90 && dy ==  0) stage = 2;
		if(dx == 90 && dy == 90) stage = 3;
		if(dx ==  0 && dy == 90) stage = 4;

		if(stage == 1) dx += 10;
		if(stage == 2) dy += 10;
		if(stage == 3) dx -= 10;
		if(stage == 4) dy -= 10;

		float red   = (float) (dx / 90.0);
		float green = (float) (dy / 90.0);
		float blue  = (float) 0.5;
		colour = new Color(red, green, blue);
	}

}


