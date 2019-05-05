package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import audios.AudioLoader;
import main.GameStateManager;
import object.GameObject;
import object.Handler;
import object.ID;
import tile.Tile;
import world.WorldLoader;

public class Level1State extends State{

	private Handler handler;
	private WorldLoader world;
	private boolean left1, right1, up1, down1,
					left2, right2, up2, down2;
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
		soundtrack.loop();
		
		left1 = right1 = up1 = down1 = false;
		left2 = right2 = up2 = down2 = false;
		
		handler = new Handler();
	
		world = new WorldLoader("res/worlds/world1.txt");
		handler.setWorld(world);
		handler.addObject(new object.Player(handler.getWorld().getSpawnP1X() * Tile.WIDTH
				, handler.getWorld().getSpawnP1Y() * Tile.HEIGHT, ID.Jugador1, handler, this, gsm));
		handler.addObject(new object.Player(handler.getWorld().getSpawnP2X() * Tile.WIDTH
				, handler.getWorld().getSpawnP2Y() * Tile.HEIGHT, ID.Jugador2, handler, this, gsm));
		handler.addObject(new object.Weapon_Assault(tile.Tile.WIDTH*(new Random().nextInt(9)+1), tile.Tile.HEIGHT*(new Random().nextInt(5)+1), ID.Arma, handler));
		handler.addObject(new object.Weapon_Launcher(tile.Tile.WIDTH*(new Random().nextInt(9)+1), tile.Tile.HEIGHT*(new Random().nextInt(4)+6), ID.Arma, handler));
		handler.addObject(new object.Weapon_Smg(tile.Tile.WIDTH*(new Random().nextInt(9)+1), tile.Tile.HEIGHT*(new Random().nextInt(3)+12), ID.Arma, handler));
		handler.addObject(new object.Weapon_Pistol(tile.Tile.WIDTH*(new Random().nextInt(4)+10), tile.Tile.HEIGHT*(new Random().nextInt(5)+1), ID.Arma, handler));
		handler.addObject(new object.Weapon_Shotgun(tile.Tile.WIDTH*(new Random().nextInt(9)+14), tile.Tile.HEIGHT*(new Random().nextInt(5)+1), ID.Arma, handler));
		handler.addObject(new object.Weapon_Minigun(tile.Tile.WIDTH*(new Random().nextInt(8)+15), tile.Tile.HEIGHT*(new Random().nextInt(5)+6), ID.Arma, handler));
		handler.addObject(new object.Weapon_Sniper(tile.Tile.WIDTH*(new Random().nextInt(10)+11), tile.Tile.HEIGHT*(new Random().nextInt(4)+11), ID.Arma, handler));
		
		
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
			if(o.getId() == ID.Jugador1)
			{
				switch(k)
				{
					case KeyEvent.VK_A:
						o.setVelX(-3);
						left1 = true;
						break;
					case KeyEvent.VK_D:
						o.setVelX(3);
						right1 = true;
						break;
					case KeyEvent.VK_W:
						o.setVelY(-3);
						up1 = true;
						break;
					case KeyEvent.VK_S:
						o.setVelY(3);
						down1 = true;
						break;
					case KeyEvent.VK_SPACE:
						o.shoot();
						break;
				}
				if(left1 && right1) o.setVelX(0);
				if(up1 && down1) o.setVelY(0);
			}
			if(o.getId() == ID.Jugador2)
			{
				switch(k)
				{
					case KeyEvent.VK_J:
						o.setVelX(-3);
						left2 = true;
						break;
					case KeyEvent.VK_L:
						o.setVelX(3);
						right2 = true;
						break;
					case KeyEvent.VK_I:
						o.setVelY(-3);
						up2 = true;
						break;
					case KeyEvent.VK_K:
						o.setVelY(3);
						down2 = true;
						break;
					case KeyEvent.VK_LEFT:
						o.shoot();
						break;
				}
				if(left2 && right2) o.setVelX(0);
				if(up2 && down2) o.setVelY(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		for (GameObject o: handler.objeto)
		{
			if(o.getId() == ID.Jugador1)
			{
				switch(k)
				{
					case KeyEvent.VK_A:
						left1 = false;
						break;
					case KeyEvent.VK_D:
						right1 = false;
						break;
					case KeyEvent.VK_W:
						up1 = false;
						break;
					case KeyEvent.VK_S:
						down1 = false;
						break;
				}
				if(!left1 && !right1) o.setVelX(0);
				if(!up1 && !down1) o.setVelY(0);
			}
			if(o.getId() == ID.Jugador2)
			{
				switch(k)
				{
					case KeyEvent.VK_J:
						left2 = false;
						break;
					case KeyEvent.VK_L:
						right2 = false;
						break;
					case KeyEvent.VK_I:
						up2 = false;
						break;
					case KeyEvent.VK_K:
						down2 = false;
						break;
				}
				if(!left2 && !right2) o.setVelX(0);
				if(!up2 && !down2) o.setVelY(0);
			}
		}
	}
}
