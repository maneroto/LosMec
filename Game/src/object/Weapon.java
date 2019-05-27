package object;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Esta es una de las clases más importantes, un arma tiene cadencia, daño y sonido
 * @author Los mec
 *
 */
public abstract class Weapon extends GameObject
{
	
	protected Handler handler;
	
	public Weapon(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		width = tile.Tile.WIDTH;
		height = tile.Tile.HEIGHT;
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void render(Graphics g);
	
	@Override
	public abstract Rectangle getBounds();
	
	public Rectangle getBounds(double xOffset, double yOffset)
	{
		return (new Rectangle((int)(x + xOffset), 
				(int) (y + yOffset), width, height));
	}

	public abstract int getDamage();

	public abstract int getSpeed();

	public abstract String getSound();

}
