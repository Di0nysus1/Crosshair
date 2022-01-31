package de.dion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Crosshair {

	private static final long serialVersionUID = -7439483220351761967L;
	private JFrame frame;
	private OverlayPanel panel;
	
	private int size = DefaultSettings.size;
	private Color color = DefaultSettings.color;
	
	
	public Crosshair() {}
	
	public void init()
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setSize(width, height);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		
		panel = new OverlayPanel();
		panel.setCrossHairSize(size);
		panel.setColor(color);
		
		frame.add(panel);
	}
	
	public void start() {
		frame.setVisible(true);
		frame.pack();
	}
	
	
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getSize() {
		return size;
	}
	
	public Color getColor() {
		return color;
	}
	
}
