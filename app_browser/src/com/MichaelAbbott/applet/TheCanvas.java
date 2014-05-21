package com.MichaelAbbott.applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TheCanvas extends Canvas {
	
	public TheCanvas() {
		this.setBackground(Color.RED);
		this.setSize(800, 500);
		
		TheListener listener = new TheListener();
		this.addMouseListener(listener);
	}
	
	public void paint(Graphics g) {
		update(g);
	}
	
	public void update(Graphics g) {
		this.setBackground(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
	}
}
