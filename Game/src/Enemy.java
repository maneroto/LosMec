import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

// Clase que define el comportamiento del enemigo
public class Enemy extends Chracter{

	// El enemigo tiene una velocidad de rebote
	// Debe de saberse a qué dirección se moverá el enemigo
	// Ayuda a mantener el tracking de la velocidad del enemigo
	// Constructor que recibe los atributos de un GameObject, más la velocidad del enemigo
	public Enemy(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler, double vel) {
		super(x, y, width, height, color, imagen, handler);
		// El enemigo tiene una velocidad de rebote de -10
		// Se le asigna una dirección aleatoria entre izquierda (negativo) y derecha (positivo)
		// Se hace que la velocidad en x sea la velocidad que se tiene, en la dirección correspondiente
		}

	// Método encargado de actualizar al enemigo
	@Override
	public void tick() 
	{	
		// Si la velocidad se vuelve menor a 10 se le suma la gravedad para que caiga
		// Se detectan las colisiones
		colision();
		
		// Si ha tocado piso

		
		// Verifica que no se salga de los límites de la ventana
		
		// Se actualiza la posición del enemigo sumándole las velocidades que tiene a sus respectivos ejes
	}

	// Método encargado de detectar las colisiones del enemigo
	@Override
	public void colision() 
	{	
		// Se genera un iterador para verificar todos los objetos contenidos en el Handler
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se genera un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			if (aux instanceof Wall)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad

				// Si hace contacto con la pared en el eje de las y al sumarle la velocidad

				
				// Si toca piso, entonces rebota
			}
		}
	}
	

}
