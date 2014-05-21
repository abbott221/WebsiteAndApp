package com.MichaelAbbott.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;


public class AppletLauncher extends Applet {
	
	
	static TheCanvas myCanvas;
	
	static Insets insets;
	
	
	public void init() {
		
		this.setLayout(null);
		
		
		
		
		JPanel canvasPanel = new JPanel();
		
		myCanvas = new TheCanvas();
		canvasPanel.add(myCanvas);
		
		this.add(canvasPanel);
		
		
		
		
		JPanel progBars = new JPanel( new GridLayout(2, 1) );
		
		JProgressBar top = new JProgressBar();
		progBars.add(top);
		
		JProgressBar bottom = new JProgressBar();
		progBars.add(bottom);
		
		this.add(progBars);
		
		
		
		
		JPanel buttons = new JPanel(new GridLayout(1, 2));
		
		JButton left = new JButton("left");
		JButton right = new JButton("right");
		
		buttons.add(left);
		buttons.add(right);
		
		this.add( buttons );
		
		
		
		
		Dimension size = canvasPanel.getPreferredSize();
		//canvasPanel.setBounds(insets.left, insets.top, size.width, size.height);
		canvasPanel.setBounds(0, 0, size.width, size.height);
		//System.out.println("height: " + size.height);
		
		
		size = progBars.getPreferredSize();
		progBars.setBounds(100, 510, 600, size.height);
		//System.out.println("height: " + size.height);
		
		size = buttons.getPreferredSize();
		buttons.setBounds(100, 540, 600, size.height);
		//System.out.println("height: " + size.height);
		
		
		myCanvas.repaint();
	}
	
	public static void main(String s[]) {
		Frame myFrame = new Frame("Hexagonal Game");
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//insets = myFrame.getInsets();
		
		Applet myApplet = new AppletLauncher();
		myApplet.setSize(800, 600);
		myFrame.add("Center", myApplet);
		myApplet.init();
		
		myFrame.pack();
		myFrame.setSize(new Dimension(800, 600));
		myFrame.setVisible(true);
		
		myCanvas.repaint();
	}
}
