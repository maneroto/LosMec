	package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import images.Assets;

/**
 * La escopeta es un arma de cadencia media y daño medio
 * @author Los mec
 *
 */
public class Weapon_Shotgun extends Weapon
{

	int weaponDamage=25;
	int weaponSpeed=750;
	String weaponSoundFile = "res\\\\sounds\\\\remington\\\\fire01.wav";
	
	public Weapon_Shotgun(double x, double y, ID id, Handler handler) {
		super(x, y, id, handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.shotgun, (int) x, (int) y , width, height, null);
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
