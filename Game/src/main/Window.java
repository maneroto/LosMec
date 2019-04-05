package main;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
	private int width, height;
	private String title;
	
	public static Canvas canvas;
	
	public Window(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createWindow();
	}

	public void createWindow()
	{
		frame = new JFrame(title);
		
		frame.setSize(width, height);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension (width, height));
		
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();

		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension (width, height));
		
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
		frame.requestFocus();
	}
	
	public Canvas getCanvas() { return canvas; }
	public JFrame getFrame() { return frame; }
}
