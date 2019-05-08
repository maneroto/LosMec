package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Weapon_Smg extends Weapon{

	int weaponDamage=10;
	int weaponSpeed=100;
	String weaponSoundFile = "res\\\\sounds\\\\uzi\\\\fire01.wav";
	
	public Weapon_Smg(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.smg, (int) x, (int) y, width, height, null);
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
