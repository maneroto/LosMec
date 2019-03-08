package image;

// Carga las librer�as que se van a utilizar
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

// Clase que se encargar� de cargar las im�genes ocupadas por el juego
public class ImageLoader {

	// M�todo que regresa una im�gen dependiendo de si existe o no la ruta
	public static BufferedImage loadImage(String path)
	{
		// Intenta cargar la im�gen
		try {
			// Regresa la im�gen dependiendo de su ruta
			return ImageIO.read(ImageLoader.class.getResource(path));
		// En caso de que no logre encontrar la im�gen
		} catch (IOException e) {
			// Imprime el error por el cu�l no se ha podido cargar la im�gen
			e.printStackTrace();
			// Dado a que no podemos cargar el juego sin im�genes, lo cierra
			System.exit(1);
		}
		// En caso de que nada lo anterior suceda, nos regresa nulo (muy raro que llegue aqu�)
		return null;
	}
	
}