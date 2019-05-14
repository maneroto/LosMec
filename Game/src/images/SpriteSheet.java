package images;

import java.awt.image.BufferedImage;

/**
 * Esta clase permite cropear el sprite sheet
 * @author Los mec
 *
 */
public class SpriteSheet 
{
	
	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}
}
