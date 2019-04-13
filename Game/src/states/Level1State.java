package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import audios.AudioLoader;
import main.GameStateManager;
import object.GameObject;
import object.ID;
import tile.Tile;
import world.WorldLoader;
import object.Handler;
import images.GameCamera;

public class Level1State extends State{

	private Handler handler;
	private WorldLoader world;
	private boolean left, right, up, down;
	private AudioLoader soundtrack;

	public Level1State(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		soundtrack = new AudioLoader("res\\\\soundtrack\\\\soundtrack.wav");
		soundtrack.play();
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		handler = new Handler();

		gameCamera = new GameCamera(handler, 0,0);
	
		world = new WorldLoader(handler, "res/worlds/world1.txt");
		
		handler.setCamera(gameCamera);
		handler.setWorld(world);
		handler.addObject(new object.Player(handler.getWorld().getSpawnX() * Tile.WIDTH
				, handler.getWorld().getSpawnY() * Tile.HEIGHT, ID.Jugador, handler, this, gsm));
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		handler.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		handler.render(g);
	}
	
	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		for (GameObject o: handler.objeto)
		{
			if(o.getId() == ID.Jugador)
			{
				switch(k)
				{
					case KeyEvent.VK_A:
						o.setVelX(-4);
						left = true;
						break;
					case KeyEvent.VK_D:
						o.setVelX(4);
						right = true;
						break;
					case KeyEvent.VK_W:
						o.setVelY(-4);
						up = true;
						break;
					case KeyEvent.VK_S:
						o.setVelY(4);
						down = true;
						break;
					case KeyEvent.VK_SPACE:
						o.shoot();
						break;
				}
				if(left && right) o.setVelX(0);
				if(up && down) o.setVelY(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		for (GameObject o: handler.objeto)
		{
			if(o.getId() == ID.Jugador)
			{
				switch(k)
				{
					case KeyEvent.VK_A:
						left = false;
						break;
					case KeyEvent.VK_D:
						right = false;
						break;
					case KeyEvent.VK_W:
						up = false;
						break;
					case KeyEvent.VK_S:
						down = false;
						break;
				}
				if(!left && !right) o.setVelX(0);
				if(!up && !down) o.setVelY(0);
			}
		}
	}
}
