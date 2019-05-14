package images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Esta clase permite cargar los assets externos a nuestro videojuego
 * @author Los mec 
 *
 */
public class ImageLoader 
{

	public static BufferedImage loadImage(String path)
	{
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
