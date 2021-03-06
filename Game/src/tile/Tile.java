package tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import object.GameObject;
import object.ID;

/**
 * Un tile es un "objeto" que puede ser s�lido/visual y se usa para construir nuestros mapas por medio de ID's
 * @author Los mec
 *
 */
public abstract class Tile extends GameObject
{

	public static Tile[]tiles = new Tile[256];
	
	public static Tile floor1 = new LimestoneFloor(1);
	public static Tile wall1 = new MetalWall(2);
	public static Tile crystalWall = new CrystalWall(3);
	public static Tile mosaicFloor = new MosaicFloor(4);
	public static Tile lavaWall = new LavaWall(5);
	
	protected int iden;
	public static final int WIDTH = 48;
	public static final int HEIGHT = 48;

	public Tile(BufferedImage imagen, int iden) {
		super(imagen);
		this.iden = iden;
		tiles[iden] = this;
		width = WIDTH;
		height = HEIGHT;
	}

	public void tick() {
		
		
	}

	public boolean isSolid()
	{
		return false;
	}

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
