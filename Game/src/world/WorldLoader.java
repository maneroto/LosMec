package world;

import java.awt.Graphics;
import tile.Tile;

/**
 * Ya que se cargó el mapa, se tiene que interpretar y construir
 * @author Los mec
 *
 */
public class WorldLoader 
{
	private int width;
	private int height;
	private int spawnP1X, spawnP1Y, spawnP2X, spawnP2Y;
	private int [][] tiles;

	public WorldLoader(String path)
	{
		loadWorld(path);
	}

	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;
		
		for (int y = yStart; y < yEnd; y++)
		{
			
			for (int x = xStart; x < xEnd ; x ++)
			{
				getTile(x, y).render
				(g, 
						(int) (x * Tile.WIDTH), 
						(int) (y * Tile.HEIGHT));
				
			}
		}
	}

	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.wall1;
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.wall1;
		return t;
	}

	public int getSpawnP1X() {return spawnP1X;}

	public int getSpawnP1Y() {return spawnP1Y;}
	
	public int getSpawnP2X() {return spawnP2X;}

	public int getSpawnP2Y() {return spawnP2Y;}
	
	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String [] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnP1X = Utils.parseInt(tokens[2]);
		spawnP1Y = Utils.parseInt(tokens[3]);
		spawnP2X = Utils.parseInt(tokens[4]);
		spawnP2Y = Utils.parseInt(tokens[5]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x ++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x+y *width) + 6]);
			}
		}
	}

	public int getWidth() { return width; }

	public int getHeight() { return height; }
}
