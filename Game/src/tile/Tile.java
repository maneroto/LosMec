package tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import object.GameObject;
import object.ID;

public abstract class Tile extends GameObject{

	public static Tile[]tiles = new Tile[256];
	
	protected int iden;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;

	public Tile(BufferedImage imagen, int iden) {
		super(imagen);
		this.iden = iden;
		tiles[iden] = this;
		width = WIDTH;
		height = HEIGHT;
	}

	public void tick() {
		
		
	}

	public abstract boolean isSolid();

	public Rectangle getBounds()
	{
		return (new Rectangle((int)x, (int)y, width, height));
	}

	public void render(Graphics g)
	{
		g.drawImage(imagen, (int)x, (int)y, width, height, null);
	}

	public void render(Graphics g, int x, int y)
	{
		this.x = x;
		this.y = y;
		g.drawImage(imagen, x, y, width, height, null);
	}

	public ID getId()
	{
		return id;
	}

	public int getIden()
	{
		return iden;
	}

}
