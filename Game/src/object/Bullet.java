package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ListIterator;

import audios.AudioLoader;
import images.Assets;
import tile.Tile;

public class Bullet extends Character{
	
	private int bulletSpeed, bulletDamage;
	AudioLoader bulletColision;
	AudioLoader death;
	
	public Bullet(double x, double y, ID id, Handler handler, char direction, int bulletSpeed, int bulletDamage, String bulletColision)
	{
		super(x,y,id, handler);
		width = 2;
		height = 2;
		this.dirAtaque = direction;
		this.bulletSpeed = bulletSpeed;
		this.bulletDamage = bulletDamage;
		bounds= new Rectangle(0, 0, width, height);
		this.bulletColision = new AudioLoader(bulletColision);
		death = new AudioLoader("res\\\\sounds\\\\death.wav");
	}

	public void tick() {
		switch(dirAtaque)
		{
			case 'u': velY = -bulletSpeed;break;
			case 'd': velY = bulletSpeed;break;
			case 'l': velX = -bulletSpeed;break;
			case 'r': velX = bulletSpeed; break;
		}
		move();
		colisionItem((int)velX, 0);
		colisionItem(0, (int)velY);
	}
	@Override
	public void move()
	{
		moveX();
		moveY();
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawOval((int)x, (int)y, width, height);
		g.fillOval((int)x, (int)y, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return (new Rectangle((int)x, (int) y, width, height));
	}

	@Override
	public void moveX(){
		if(velX > 0){//Moving right
			int tx = (int) (x + velX + bounds.x + bounds.width) / Tile.WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += velX;
			}else{
				bulletColision.play();
				handler.removeObject(this);
			}
			
		}else if(velX < 0){//Moving left
			int tx = (int) (x + velX + bounds.x) / Tile.WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += velX;
			}else{
				bulletColision.play();
				handler.removeObject(this);
			}
			
		}
	}
	
	@Override
	public void moveY(){
		if(velY < 0){//Up
			int ty = (int) (y + velY + bounds.y) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += velY;
			}else{
				bulletColision.play();
				handler.removeObject(this);
			}
			
		}else if(velY > 0){//Down
			int ty = (int) (y + velY + bounds.y + bounds.height) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += velY;
			}else{
				bulletColision.play();
				handler.removeObject(this);
			}
			
		}
	}
	
	public void colisionItem(double xOffset, double yOffset)
	{
		for (GameObject o: handler.objeto)
		{
			if(o instanceof Player)
			{
				if(((Player)o).getBounds(0,0).intersects(getBounds(xOffset,yOffset)))
				{	
					handler.removeObject(this);
					((Player)o).setVida(((Player)o).getVida()-bulletDamage);
					if (((Player)o).getVida() <= 0) 
					{
						death.play();
					}
					else 
					{
						bulletColision.play();
					}
				}
			}
		}
	}

	@Override
	public void muerto() {
		// TODO Auto-generated method stub
		
	}
}
