package images;

import object.GameObject;
import object.Handler;
import main.GameLoop;
import tile.Tile;

/**
 * Esta clase permit�a controlar una c�mara que segu�a al jugador pero actualmente es obsoleta
 * @author Los mec
 *
 */
public class GameCamera 
{
	private double xOffset;
	private double yOffset;
	private Handler handler;

	public GameCamera(Handler handler, double xOffset, double yOffset)
	{
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(double cantidadX, double cantidadY)
	{
		xOffset += cantidadX;
		yOffset += cantidadY;
		checkBlankSpace();
	}

	public void checkBlankSpace()
	{
		if (xOffset < 0) xOffset = 0;
		else if(xOffset > handler.getWorld().getWidth() * Tile.WIDTH - GameLoop.width+3)
		{
			xOffset = handler.getWorld().getWidth() * Tile.WIDTH - GameLoop.width+3;
		}
		if (yOffset < 0) yOffset = 0;
		else if(yOffset > handler.getWorld().getHeight() * Tile.HEIGHT - GameLoop.height + 30)
		{
			yOffset = handler.getWorld().getHeight() * Tile.HEIGHT - GameLoop.height + 30;
		}
	}

	public void centerOnObject(GameObject o)
	{
		xOffset = o.getX() - GameLoop.width / 2 + o.getWidth() / 2;
		yOffset = o.getY() - GameLoop.height / 2 + o.getHeight() / 2;
		checkBlankSpace();
	}

	public double getXOffset() { return xOffset; }

	public double getYOffset() { return yOffset; }
}
