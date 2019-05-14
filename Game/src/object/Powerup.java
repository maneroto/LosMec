package object;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Originalmente el juego iba a tener powerups, pero sentimos que estaban muy poderosos y se quedaron OBSOLETOS
 * @author Los mec
 *
 */
public abstract class Powerup extends GameObject
{
	
	protected Handler handler;
	
	public Powerup(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
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
	
	public abstract int getBonus();
}
