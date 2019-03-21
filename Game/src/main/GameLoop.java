package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import images.Assets;

public class GameLoop implements Runnable {
	
	public static int width, height;
	public String title;
	
	public Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	private Window window;
	private GameStateManager gsm;
	public KeyInput keyInput;
	
	public GameLoop (String title, int width, int height)
	{
		this.title = title;
		GameLoop.width = width;
		GameLoop.height = height;
	}
	public void init()
	{
		Assets.init();
		window = new Window(title, width, height);
		gsm = new GameStateManager();
		keyInput = new KeyInput(gsm);
		
		window.getFrame().addKeyListener(keyInput);
	}
	@Override
	public void run() {
		
		init();
		
		int fps = 60, ticks = 0;
		double timePerTick = 1000000000 / fps, delta = 0;
		long now, lastTime = System.nanoTime(), timer = 0;
		
		while (running)
		{
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1)
			{
				ticks ++;
				delta --;
			}
			if (timer >= 1000000000)
			{
				System.out.println("Ticks and frames: " + ticks);
				timer = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	public void render()
	{
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		gsm.render(g);
		
		bs.show();
		g.dispose();
	}
	public void tick()
	{
		gsm.tick();
	}
	public synchronized void start()
	{
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if (!running) return;
		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }

}
