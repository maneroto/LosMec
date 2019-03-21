package world;

import java.awt.Graphics;
import tile.Tile;

public class WorldLoader {
	private int width;
	private int height;
	private int spawnX, spawnY;
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
				getTile(x, y).render(g, (int) (x * Tile.WIDTH), (int) (y * Tile.HEIGHT));
			}
		}
	}

	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y >= height) return null;//return Tile.defaultTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return null;
			// return Tile.defaultTile2;
		return t;
	}

	public int getSpawnX() {return spawnX;}

	public int getSpawnY() {return spawnY;}

	private void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String [] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x ++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x+y *width) + 4]);
			}
		}
	}

	public int getWidth() { return width; }

	public int getHeight() { return height; }
}
