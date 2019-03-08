import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Clase que designa el comportamiento de los personajes del juego
public abstract class Chracter extends GameObject{
	
	// Es un juego de plataformas, por lo que tiene gravedad, velocidad en x y en y
	protected BufferedImage imagen;
	// Constructor que pide los valores del Game object 
	public Chracter(double x, double y, int width, int height, Color color, BufferedImage imagen, Handler handler) {
		super(x, y, width, height, color, handler);
		// Se asigna la velocidad en x a que por defecto sea de 3
		this.imagen = imagen;
	}

	// Pinta al personaje
	@Override
	public void paint(Graphics g) 
	{		
		// Se le asigna el color que el personaje tiene
		//g.setColor(color);
		// Los personajes en �ste caso son �valos, as� que los dibujamos
		//g.fillOval(getX(),getY(), width, height);
		g.drawImage(imagen, getX(), getY(), width, height, null);
	}

	// Todo personaje tiene un comportamiento diferente, as� que el tick sigue siendo abstracto
	public abstract void tick();
	
	// Todos los personajes en �ste juego tienen colisi�n
	public abstract void colision();
	
	// Obtenemos los bordes del personaje
	@Override
	public Rectangle getBounds() 
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
	
	// Place meeting nos ayuda a revisar si el personaje colisiona con otro objeto
	public boolean placeMeeting (double x, double y, GameObject obj)
	{
		// revisa si el rect�ngulo del otro objeto intersecta con el rect�ngulo del personaje
		if ((new Rectangle((int)x, (int)y, width, height)).intersects(obj.getBounds())) 
			return true;
		return false;
	}
	
	// M�todo que nos ayuda a identificar cuando e personaje ha tocado piso
	public boolean onFloor()
	{
		// Para cada objeto contenido en el Handler
		for (GameObject obj: handler.obj)
			// Si el objeto es una pared
			if (obj instanceof Wall)
				// Revisa si est� toc�ndolo el personaje
				if (placeMeeting(x,y+1,obj))
					return true;
		return false;
	}
	
	// A partir de aqu� son los setters y getters

}
