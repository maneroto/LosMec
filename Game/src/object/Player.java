package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import audios.AudioLoader;
import images.Animation;
import main.GameStateManager;
import states.State;
import images.Assets;
import tile.Tile;

public class Player extends Character{
	
	private GameStateManager gsm;
	private State s;
	private Animation animation;
	private long lastTime, timer;
	char bulletDirection='u';
	int weaponDamage = 20;
	int weaponSpeed = 150;
	String weaponSoundFile = "res\\\\sounds\\\\glock_18\\\\fire01.wav";
	AudioLoader weaponSound = new AudioLoader(weaponSoundFile);

	public Player(double x, double y, ID id, Handler handler, State s, GameStateManager gsm) {
		super(x, y,  id, handler);
		// TODO Auto-generated constructor stub
		vida = 100;
		daño = 20;
		width = 200;
		height = 200;
		this.s = s;
		bounds= new Rectangle(0, 0, width, height);
		bounds.y = 80;
		bounds.x = 80;
		bounds.width = 40;
		bounds.height = 40;
		this.id = ID.Jugador;
		this.gsm = gsm;
		
		atacando = false;
		
		tiempoRecargaAtaque = 300;
		atackTimer = tiempoRecargaAtaque;
		
		animation = new Animation(10, Assets.p1Pistol);
	}

	@Override
	public void tick() {
		
		move();		
		tickDirection();
		//System.out.println(bulletDirection);
		
		colisionItem((int)velX, 0);
		colisionItem(0, (int)velY);
		
		vida = (int) clamp(vida, 0, 100);
		
		s.getCamera().centerOnObject(this);
	}
	
	public void  tickDirection() {
		if(velY > 0) {
			bulletDirection = 'd';
		}
		else if(velY < 0) {
			bulletDirection = 'u';
		}	
		else if (velX > 0) {
			bulletDirection = 'r';
		}
		else if (velX < 0) {
			bulletDirection = 'l';
		}
	}
	
	public void herir(double cantidad)
	{
		muerto();
	}

	public void moveX(){
		if(velX > 0){//Moving right
			int tx = (int) (x + velX + bounds.x + bounds.width) / Tile.WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += velX;
			}else{
				x = tx * Tile.WIDTH - bounds.x - bounds.width - 1;
			}
			animation.setCurrentFrame(3);
			
		}else if(velX < 0){//Moving left
			int tx = (int) (x + velX + bounds.x) / Tile.WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += velX;
			}else{
				x = tx * Tile.WIDTH + Tile.WIDTH - bounds.x;
			}
			animation.setCurrentFrame(1);
		}
	}

	public void moveY(){
		if(velY < 0){//Up
			int ty = (int) (y + velY + bounds.y) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += velY;
			}else{
				y = ty * Tile.HEIGHT + Tile.HEIGHT - bounds.y;
			}
			animation.setCurrentFrame(0);
			
		}else if(velY > 0){//Down
			int ty = (int) (y + velY + bounds.y + bounds.height) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += velY;
			}else{
				y = ty * Tile.HEIGHT - bounds.y - bounds.height - 1;
			}
			animation.setCurrentFrame(2);
		}
	}
	/**
	 * Remueve el objeto del ArrayList del Handler si su vida llega a 0
	 * Cambia el estado al estado de muerto
	 */
	public void muerto()
	{
	}
	
	@Override
	/**
	 * Realiza la accion de atacar
	 */
	public void atacar()
	{
		atackTimer += System.currentTimeMillis() - lastAtackTimer;
		lastAtackTimer = System.currentTimeMillis();
		
		if(atackTimer < tiempoRecargaAtaque)return;
		
		atacando = true;
		
		Rectangle cb = getBounds(0,0);
		Rectangle ataque = new Rectangle();
		int atqWidth = 22;
		int atqHeight = 32;
		ataque.width = atqWidth + 5;
		ataque.height = atqHeight;
		
		if (dirAtaque == -1)
		{
			ataque.x = cb.x - atqWidth - 5;
			ataque.y = cb.y + cb.height / 2 - atqHeight / 2;
		}
		else if(dirAtaque == 1)
		{
			ataque.x = cb.x + atqWidth - 10;
			ataque.y = cb.y + cb.height / 2 - atqHeight / 2;
		}
		
		atackTimer = 0;
		

	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - s.getCamera().getXOffset())
				, (int) (y - s.getCamera().getYOffset()), 
				width, height, null);
		g.setColor(Color.WHITE);
		g.drawRect((int)(x+bounds.x - s.getCamera().getXOffset()),(int)(y+bounds.y - s.getCamera().getYOffset()), bounds.width, bounds.height);
	}
	
	public BufferedImage getCurrentAnimationFrame()
	{
		return animation.getCurrentFrame();
	}
	
	@Override
	public Rectangle getBounds() {
			return new Rectangle((int)x + 11, (int)y, 12, height);
	}

	public boolean colisionSolido(int x, int y)
	{
		return handler.getWorld().getTile(x, y).getId() == ID.Solido;
	}

	public void colisionItem(double xOffset, double yOffset)
	{
		for (GameObject o: handler.objeto)
		{
			if(o.getId() == ID.Arma) 
			{
				if(o instanceof Weapon_Assault)
				{
					if(((Weapon_Assault)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{	
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Assault);
					}
				}
				if(o instanceof Weapon_Pistol)
				{
					if(((Weapon_Pistol)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Pistol);
					}
				}
				if(o instanceof Weapon_Launcher)
				{
					if(((Weapon_Launcher)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{	
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Launcher);
					}
				}
				if(o instanceof Weapon_Minigun)
				{
					if(((Weapon_Minigun)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Minigun);
					}
				}
				if(o instanceof Weapon_Shotgun)
				{
					if(((Weapon_Shotgun)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{	
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Shotgun);
					}
				}
				if(o instanceof Weapon_Smg)
				{
					if(((Weapon_Smg)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Smg);
					}
				}
				if(o instanceof Weapon_Sniper)
				{
					if(((Weapon_Sniper)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						weaponDamage = ((Weapon)o).getDamage();
						weaponSpeed = ((Weapon)o).getSpeed();
						weaponSoundFile = ((Weapon)o).getSound();
						handler.removeObject(o);
						animation = new Animation(10, Assets.p1Sniper);
					}
				}
			}
				
		}
	}
		
	@Override
	public void shoot() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(timer > weaponSpeed)
		{
			timer = 0;
			int bulletXOffset = 0, bulletYOffset = 0;
			if(bulletDirection == 'u')
			{
				bulletXOffset = 30;
			}
			else if(bulletDirection == 'r')
			{
				bulletYOffset = 30;
				bulletXOffset = 30;
			}
			else if(bulletDirection == 'd')
			{
				bulletYOffset = 30;
			}
			handler.addObject(new object.Bullet((int)(x - s.getCamera().getXOffset() + bounds.x + bulletXOffset), (int)(y - s.getCamera().getYOffset() + bounds.y + bulletYOffset), ID.Bala, bulletDirection, 10));
			weaponSound.setLocation(weaponSoundFile);
			weaponSound.play();
		}
	}
}
