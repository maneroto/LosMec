package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Player extends Character{

	Handler handler;
	int hp;
	int damage;
	long lastAttackTimer;
	long timerReloadNormal;
	long attackTimer;
	int dirAttack;
	boolean attacking;
	int scorePoint;
	double gravity;
	Rectangle jump;
	public boolean canJump;
	public boolean canTakeDamage;
	
	public Player(BufferedImage imagen, double x, double y, Handler handler) {
		super(imagen, x, y, handler);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public boolean onFloor()
	{
		return false;
	}
	
	public void tick()
	{
		//What to do?
	}
	
	public void render (Graphics g)
	{
		//what to do?
	}
	
	public void attack()
	{
		//what to do?
	}
	
	public void moveX(boolean up)
	{
		if(up)
		{
			x -= velX;
		}
		else
		{
			x += velX;
		}
	}
	
	public void moveY(boolean left)
	{
		if(left)
		{
			y -= velY;
		}
		else
		{
			y += velY;
		}
	}
	
	public void dead()
	{
		//init pv and position;
		hp = 0;
	}
	
	public void hurt(int amount)
	{
		hp -= amount;
	}
	
	public Rectangle getBounds(double xOffset, double yOffset)
	{
		//what to do?
		return null;
	}
	
	public String toString()
	{
		//waht to do?
		return "";
	}
	
	public void setLife(int life)
	{
		hp = life;
	}
	
	public void setDamage(int amount)
	{
		damage = amount;
	}
	
	public void setAttackTimer(int reloadAttackTime)
	{
		attackTimer = reloadAttackTime;
	}
	
	public int getLife()
	{
		return hp;
	}
	
	public double getDamage()
	{
		return damage;
	}
	
	public long getReloadTime()
	{
		return timerReloadNormal;
	}
	
	public void setAttacking(boolean active)
	{
		attacking = active;
	}
	
	public void Immunate(boolean active)
	{
		canTakeDamage = active;
	}
	
}
