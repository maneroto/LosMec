package object;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import audios.AudioLoader;
import images.Animation;
import images.Assets;
import main.GameStateManager;
import tile.Tile;

/**
 * Esta clase crea al jugador que puede ser J1 o J2 dependiendo de su ID
 * @author Los mec
 *
 */
public class Player extends Character
{
	
	private GameStateManager gsm;
	private Animation animation;
	private long lastTime, timer;
	char bulletDirection='u';
	int weaponDamage;
	int weaponSpeed;
	HUD hud;
	String weaponSoundFile = "res\\\\sounds\\\\glock_18\\\\fire01.wav", bulletColisionFile;
	AudioLoader weaponSound = new AudioLoader(weaponSoundFile)
			, reload = new AudioLoader("res\\\\sounds\\\\franchi\\\\pump.wav");

	public Player(double x, double y, ID id, Handler handler, GameStateManager gsm, HUD hud) 
	{
		super(x, y,  id, handler);
		// TODO Auto-generated constructor stub
		vida = 100;
		width = 200;
		height = 200;
		bounds= new Rectangle(0, 0, width, height);
		bounds.y = 80;
		bounds.x = 80;
		bounds.width = 40;
		bounds.height = 40;
		this.id = id;
		weaponSpeed = 150;
		this.gsm = gsm;
		weaponDamage = 10;
		bulletColisionFile = "res\\\\sounds\\\\silencer\\\\fire01.wav";
		if(id == ID.Jugador1) animation = new Animation(10, Assets.p1Pistol);
		else animation = new Animation(10, Assets.p2Pistol);
		this.hud = hud;
	}

	@Override
	public void tick() 
	{
		
		if(this.id == ID.Jugador1)
		{
			hud.setVidaP1(vida);
		} 
		else if(this.id == ID.Jugador2)
		{
			hud.setVidaP2(vida);
		}
		move();		
		tickDirection();
		//System.out.println(bulletDirection);
		
		colisionItem((int)velX, 0);
		colisionItem(0, (int)velY);
		
		vida = (int) clamp(vida, 0, 100);
		muerto();
		
	}
	
	public void  tickDirection() 
	{
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

	public void moveX()
	{
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

	public void moveY()
	{
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
	
	public void muerto()
	{
		if(vida <= 0)
		{
			if (this.id == ID.Jugador1)
			{
				gsm.setSate(GameStateManager.PLAYER2WINS_STATE);
			}
			else if(this.id == ID.Jugador2)
			{
				gsm.setSate(GameStateManager.PLAYER1WINS_STATE);
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
		//g.setColor(Color.WHITE);
		//g.drawRect((int)(x+bounds.x),(int)(y+bounds.y), bounds.width, bounds.height);
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
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Assault);
						else changeWeapon((Weapon)o, Assets.p2Assault);
					}
				}
				if(o instanceof Weapon_Pistol)
				{
					if(((Weapon_Pistol)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Pistol);
						else changeWeapon((Weapon)o, Assets.p2Pistol);
					}
				}
				if(o instanceof Weapon_Launcher)
				{
					if(((Weapon_Launcher)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{	
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Launcher);
						else changeWeapon((Weapon)o, Assets.p2Launcher);
						bulletColisionFile = "res\\\\sounds\\\\rocket_launcher\\\\rocket_explode_MONO.wav";
					}
				}
				if(o instanceof Weapon_Minigun)
				{
					if(((Weapon_Minigun)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Minigun);
						else changeWeapon((Weapon)o, Assets.p2Minigun);
					}
				}
				if(o instanceof Weapon_Shotgun)
				{
					if(((Weapon_Shotgun)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{	
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Shotgun);
						else changeWeapon((Weapon)o, Assets.p2Shotgun);
					}
				}
				if(o instanceof Weapon_Smg)
				{
					if(((Weapon_Smg)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Smg);
						else changeWeapon((Weapon)o, Assets.p2Smg);
					}
				}
				if(o instanceof Weapon_Sniper)
				{
					if(((Weapon_Sniper)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
					{
						if(id == ID.Jugador1) changeWeapon((Weapon)o, Assets.p1Sniper);
						else changeWeapon((Weapon)o, Assets.p2Sniper);
					}
				}
			}
				
		}
	}
	
	public void changeWeapon(Weapon o, BufferedImage[] anim)
	{
		weaponDamage = ((Weapon)o).getDamage();
		weaponSpeed = ((Weapon)o).getSpeed();
		weaponSoundFile = ((Weapon)o).getSound();
		handler.removeObject(o);
		animation = new Animation(10, anim);
		reload.play();
	}
		
	@Override
	public void shoot() {
		velX = 0;
		velY = 0;
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
			handler.addObject(new object.Bullet((int)(x + bounds.x + bulletXOffset), (int)(y + bounds.y + bulletYOffset), ID.Bala, handler, bulletDirection, 10, weaponDamage, bulletColisionFile));
			weaponSound.setLocation(weaponSoundFile);
			weaponSound.play();
		}
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getWeaponDamage() {
		return weaponDamage;
	}
}
