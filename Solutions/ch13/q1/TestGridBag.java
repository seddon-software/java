package ch13.q1;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class TestGridBag extends JApplet {
	private Container container;
	private GridBagLayout theBag;
	private GridBagConstraints constraints;

	public void PositionButton(String name) {
    Button button = new Button(name);
    theBag.setConstraints(button, constraints);
    container.add(button);
	}

  public void init() {
		try {
			setSize(new Dimension(400,300));
			theBag = new GridBagLayout();
			container = getContentPane();
    	constraints = new GridBagConstraints();

 			container.setLayout(theBag);


			constraints.ipadx = 20;
			constraints.ipady = 20;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.weightx = 0.0;

			PositionButton("T");
			PositionButton("H");
			PositionButton("I");
			PositionButton("S");

			constraints.gridy = 1;
			PositionButton("I");
			PositionButton("S");

			constraints.gridy = 2;
			PositionButton("T");
			PositionButton("H");
			PositionButton("E");

      constraints.fill = GridBagConstraints.BOTH;
			constraints.gridy = 3;
			PositionButton("G");
			PositionButton("R");
			PositionButton("I");
			PositionButton("D");
			PositionButton("B");
			PositionButton("A");
			PositionButton("G");

		} catch(Exception e) { e.printStackTrace(); }
	}
}