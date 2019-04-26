package object;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Character extends GameObject{
	
	protected Handler handler;
	protected int vida;
	protected double daño;
	protected long lastAtackTimer;
	protected long tiempoRecargaAtaque;
	protected long tiempoRecargaEspecial;
	protected long atackTimer;
	protected char dirAtaque;
	protected boolean atacando;
	protected int puntosMuerte;
	
	protected Rectangle bounds;

	public Character(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.dirAtaque = 'u';
	}

	public abstract void tick();

	public abstract void render(Graphics g);	

	public abstract void atacar();

	public abstract void moveX();

	public abstract void moveY();

	public abstract void muerto();

	public void herir(double cantidad)
	{
		this.vida -= cantidad;
		muerto();
	}

	public void move() {
		moveX();
		moveY();
		if(velX > 0) dirAtaque = 'r';
		else if (velX < 0) dirAtaque = 'l';
		if(velY > 0) dirAtaque = 'u';
		else if (velY < 0) dirAtaque = 'd';
	}

	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public String toString()
	{
		return 
				"Estadisticas del personaje tipo: " + id + "\n" +
				"Posicion X: " + x + "\n" +
				"Posicion Y: " + y + "\n" +
				"Ancho: " + width + "\n" +
				"Alto: " + height + "\n" +
				"Archivo de imagen: " + imagen + "\n" +
				"Velocidad en X: " + velX + "\n" +
				"Velocidad en Y: " + velY + "\n" +
				"Vida: " + vida + "\n" +
				"Daño: " + daño + "\n" +
				"Tiempo de recarga de ataque: " + tiempoRecargaAtaque + "\n" +
				"Tiempo de recarga de ataque especial: " + tiempoRecargaEspecial
				;
	}

	public Rectangle getBounds(double xOffset, double yOffset)
	{
		return (new Rectangle((int)(x + bounds.x + xOffset), 
				(int) (y + bounds.y + yOffset), bounds.width, bounds.height));
	}

	public void setVida(int vida)
	{
		this.vida = vida;
	}

	public void setDaño(double daño)
	{
		this.daño = daño;
	}

	public void setTiempoRecargaAtaque(int tiempoRecargaAtaque)
	{
		this.tiempoRecargaAtaque = tiempoRecargaAtaque;
	}

	public void setTiempoRecargaEspecial(int tiemporecargaEspecial)
	{
		this.tiempoRecargaEspecial = tiemporecargaEspecial;
	}

	public int getVida()
	{
		return vida;
	}

	public double getDaño()
	{
		return daño;
	}

	public long getTiempoRecargaAtaque()
	{
		return tiempoRecargaAtaque;
	}

	public long getTiempoRecargaEspecial()
	{
		return tiempoRecargaEspecial;
	}

	public void setAtacando(boolean atacando)
	{
		this.atacando = atacando;
	}
}
