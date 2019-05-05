package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import audios.AudioLoader;
import tile.Tile;

public class Bullet extends Character{
	private int bulletSpeed;
	AudioLoader bulletColision;
	public Bullet(double x, double y, ID id, Handler handler, char direction, int bulletSpeed)
	{
		super(x,y,id, handler);
		width = 5;
		height = 5;
		this.dirAtaque = direction;
		this.bulletSpeed = bulletSpeed;
		bounds= new Rectangle(0, 0, width, height);
		bulletColision = new AudioLoader("res\\\\sounds\\\\silencer\\\\fire01.wav");
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
	public void atacar() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void muerto() {
		// TODO Auto-generated method stub
		
	}
}
