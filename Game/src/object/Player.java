package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import images.Animation;
import main.GameStateManager;
import states.State;
import images.Assets;
import tile.Tile;

public class Player extends Character{
	
	private GameStateManager gsm;
	private State s;
	private Animation p1Pistol;

	public Player(double x, double y, ID id, Handler handler, State s, GameStateManager gsm) {
		super(x, y,  id, handler);
		// TODO Auto-generated constructor stub
		vida = 100;
		daño = 20;
		width = 64;
		height = 64;
		this.s = s;
		bounds= new Rectangle(0, 0, width, height);
		bounds.y = 20;
		bounds.x = 20;
		bounds.width = 27;
		bounds.height = 27;
		this.id = ID.Jugador;
		this.gsm = gsm;
		
		atacando = false;
		
		tiempoRecargaAtaque = 300;
		atackTimer = tiempoRecargaAtaque;
		
		p1Pistol = new Animation(10, Assets.p1Pistol);
	}

	@Override
	public void tick() {
		
		move();
		
		colisionItem((int)velX, 0);
		colisionItem(0, (int)velY);
		
		vida = (int) clamp(vida, 0, 100);
		
		s.getCamera().centerOnObject(this);
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
			p1Pistol.setCurrentFrame(3);
			
		}else if(velX < 0){//Moving left
			int tx = (int) (x + velX + bounds.x) / Tile.WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += velX;
			}else{
				x = tx * Tile.WIDTH + Tile.WIDTH - bounds.x;
			}
			p1Pistol.setCurrentFrame(1);
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
			p1Pistol.setCurrentFrame(0);
			
		}else if(velY > 0){//Down
			int ty = (int) (y + velY + bounds.y + bounds.height) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += velY;
			}else{
				y = ty * Tile.HEIGHT - bounds.y - bounds.height - 1;
			}
			p1Pistol.setCurrentFrame(2);
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
		
		for (GameObject o: handler.objeto)
		{
			if(o.getId() == ID.Enemigo)
			{
				if(o.getBounds().intersects(ataque))
				{
					System.out.println("Boom");
					((Character) o).herir(daño);
					((Character) o).setX(((Character) o).getX() + (((Character) o).getVelX() / 2 - 8) *-1);
					return;
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - s.getCamera().getXOffset())
				, (int) (y - s.getCamera().getYOffset()), 
				width, height, null);		
	}
	
	public BufferedImage getCurrentAnimationFrame()
	{
		return p1Pistol.getCurrentFrame();
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
			
		}
	}

}
