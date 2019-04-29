package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Weapon_Launcher extends Weapon{

	int weaponDamage=100;
	int weaponSpeed=2000;
	String weaponSoundFile = "res\\\\sounds\\\\rocket_launcher\\\\fire01.wav";
	
	public Weapon_Launcher(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
		width = tile.Tile.WIDTH/4;
		height = tile.Tile.HEIGHT*2;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.launcher, (int) (x - handler.getCamera().getXOffset()),
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
