package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Weapon_Sniper extends Weapon{

	int weaponDamage=100;
	int weaponSpeed=1500;
	String weaponSoundFile = "res\\\\sounds\\\\dragunov\\\\fire01.wav";
	
	public Weapon_Sniper(double x, double y, ID id, Handler handler) {
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
		g.drawImage(Assets.sniper, (int) (x - handler.getCamera().getXOffset()),
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