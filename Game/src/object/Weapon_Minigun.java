package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Weapon_Minigun extends Weapon{

	int weaponDamage=1;
	int weaponSpeed=15;
	String weaponSoundFile = "res\\\\sounds\\\\minigun_carry\\\\fire01.wav";
	
	public Weapon_Minigun(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
		width = tile.Tile.WIDTH/3;
		height = tile.Tile.HEIGHT+tile.Tile.HEIGHT/2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.minigun, (int) (x - handler.getCamera().getXOffset()),
				(int) (y - handler.getCamera().getYOffset()), width, height, null);
	}
	
	@Override
	public Rectangle getBounds() {
		return (new Rectangle((int) x, (int) y, width, height));
	}

	@Override
	public int getDamage() {
		return weaponDamage;
	}

	@Override
	public int getSpeed() {
		return weaponSpeed;
	}
	
	@Override
	public String getSound() {
		return weaponSoundFile;
	}

}
