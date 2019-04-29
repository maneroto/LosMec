package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import images.Assets;

public class GameLoop implements Runnable{
	
	public static int width;
	public static int height;
	public String title;
	
	private Thread thread;
	
	private Window ventana;
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	private GameStateManager gsm;
	private KeyInput keyInput;

	public GameLoop( String title, int width, int height)
	{
		GameLoop.width = width;
		GameLoop.height = height;
		this.title = title;
	}

	public void init()
	{
		Assets.init();
		ventana = new Window(title, width, height);
		gsm = new GameStateManager();
		keyInput = new KeyInput(gsm);
		
		ventana.getFrame().addKeyListener(keyInput);
	}

	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void tick()
	{
		gsm.tick();
	}

	public void render()
	{
		bs = ventana.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		gsm.render(g);

		bs.show();
		g.dispose();
	}

	public void run()
	{
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				ticks ++;
				delta--;
			}
			
			if (timer >= 1000000000)
			{
				//System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}

	public static double clamp(double var, double min, double max)
	{
		if (var <= min) return var = min;
		else if (var >= max) return var = max;
		else return var;
	}

	public int getWidth() { return width;}

	public int getHeight() { return height;}
}
