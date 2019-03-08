import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

// Clase que define el comportamiento del jugador
public class Player extends Chracter{

	// Tiene una velocidad al rebotar

	// Constructor que recibe los atributos de un GameObject
	public Player(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler) {
		super(x, y, width, height, color, imagen, handler);
		// La velocidad al rebotar por defecto es de -8
		// Es -8 dado a que al rebotar, la pelota se mueve a arriba (negativo)
		}
	
	// Método que nos ayuda a actualizar al jugador
	@Override
	public void tick() 
	{	
		// Si la velocidad en y llega a ser menor a 10, entonces se le resta la gravedad para que caiga
		// Se revisan las colisiones
		colision();
		
		// Se revisa que no se salga de los límites de la ventana
		
		// Se actualiza la posición en x y en y con respecto a su velocidad
	}
	
	// Método que se encarga de detectar las colisiones
	@Override
	public void colision() 
	{	
		// Se genera un iterador para revisar todos los objetos
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			
			// Si el auxiliar es un enemigo

		}
	}

	// Método que lee las teclas que han sido presionadas
	public void keyPressed(int key) {
		// Si es escape, cierra el juego
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		// Si es la flecha izquierda, vuelve la velocidad en x -3
		if (key == KeyEvent.VK_LEFT) x -= 3;
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) x  +=3;
		if (key == KeyEvent.VK_UP) y -= 3;
		if (key == KeyEvent.VK_DOWN) y  +=3;
		
		// Si la tecla presionada es espacio cambia la distancia de salto

	}

	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}

}
