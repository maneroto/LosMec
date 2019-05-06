package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Powerup_Health extends Powerup{

	int bonus = 100;
	
	public Powerup_Health(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
		width = tile.Tile.WIDTH/2;
		height = tile.Tile.HEIGHT/2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.health, (int) (x - handler.getCamera().getXOffset()),
				(int) (y - handler.getCamera().getYOffset()), width, height, null);
	}
	
	@Override
	public Rectangle getBounds() {
		return (new Rectangle((int) x, (int) y, width, height));
	}

	@Override
	public int getBonus() {
		return bonus;
	}

}
