import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// Clase Pared (En caso de tener varias, �sta puede ser abstracta)
public class Wall extends GameObject{
	// Constructor que recibe los atributos de un GameObject
	public Wall(double x, double y, int width, int height, Color color, Handler handler)
	{
		super (x,y,width,height,color,handler);
	}
	
	// La pared solo requiere ser pintada
	@Override
	public void paint(Graphics g)
	{
		// Se le da un color
		g.setColor(color);
		// Se pinta el rect�ngulo de la pared
		// En �ste caso ha sido comentado, ya que el background nos ayuda visualmente
		g.fillRect(getX(), getY(), width, height);
	}
	
	// La pared no requiere actualizar nada (posici�n, color y tama�o se mantienen constantes)
	@Override
	public void tick() {}
	
	// Obtiene los bordes de la pared (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds()
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
}
