package object;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected BufferedImage imagen;
	protected ID id;
	protected double velX;
	protected double velY;

	public GameObject(BufferedImage imagen)
	{
		this.imagen = imagen;
	}

	public GameObject(double x, double y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public boolean placeMeeting(double x, double y, GameObject o)
	{
		if ((new Rectangle((int)x, (int)y , width, height)).intersects(o.getBounds())) 
			return true;
		return false;
	}

	public double clamp(double var, double min, double max)
	{
		if (var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public void setImagen(BufferedImage imagen)
	{
		this.imagen = imagen;
	}

	public void setID(ID id)
	{
		this.id = id;
	}

	public void setVelX(int velX)
	{
		this.velX = velX;
	}

	public void setVelY(int velY)
	{
		this.velY = velY;
	}

	public int getX()
	{
		return (int)x;
	}

	public int getY()
	{
		return (int)y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public BufferedImage getImagen()
	{
		return imagen;
	}

	public ID getId()
	{
		return id;
	}

	public int getVelX()
	{
		return (int)velX;
	}

	public int getVelY()
	{
		return (int)velY;
	}
}
