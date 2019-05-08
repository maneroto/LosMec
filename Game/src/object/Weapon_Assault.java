package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

public class Weapon_Assault extends Weapon{

	int weaponDamage=15;
	int weaponSpeed=100;
	String weaponSoundFile = "res\\\\sounds\\\\ak_47\\\\fire01.wav";
	
	public Weapon_Assault(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.assault, (int) x, (int) y, width, height, null);
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
