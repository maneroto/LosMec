package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	private char direction;
	private int bulletSpeed;
	public Bullet(double x, double y, ID id, char direction, int bulletSpeed)
	{
		super(x,y,id);
		width = 10;
		height = 10;
		this.direction = direction;
		this.bulletSpeed = bulletSpeed;
	}

	public void tick() {
		switch(direction)
		{
			case 'u': velY = -bulletSpeed;break;
			case 'd': velY = bulletSpeed;break;
			case 'l': velX = -bulletSpeed;break;
			case 'r': velX = bulletSpeed; break;
		}
		x += velX;
		y += velY;
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
}
