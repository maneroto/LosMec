package object;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Character extends GameObject{
	
	protected Handler handler;
	protected int vida;
	protected char dirAtaque;
	
	protected Rectangle bounds;

	public Character(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.dirAtaque = 'u';
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void moveX();

	public abstract void moveY();

	public abstract void muerto();

	public void herir(double cantidad)
	{
		this.vida -= cantidad;
		muerto();
	}

	public void move() {
		moveX();
		moveY();
		if(velX > 0) dirAtaque = 'r';
		else if (velX < 0) dirAtaque = 'l';
		if(velY > 0) dirAtaque = 'u';
		else if (velY < 0) dirAtaque = 'd';
	}

	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public Rectangle getBounds(double xOffset, double yOffset)
	{
		return (new Rectangle((int)(x + bounds.x + xOffset), 
				(int) (y + bounds.y + yOffset), bounds.width, bounds.height));
	}

	public void setVida(int vida)
	{
		this.vida = vida;
	}

	public int getVida()
	{
		return vida;
	}


}
