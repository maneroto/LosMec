package object;

import java.awt.Graphics;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import world.WorldLoader;

public class Handler {

	public CopyOnWriteArrayList <GameObject> objeto;
	private WorldLoader world;

	public Handler()
	{
		objeto = new CopyOnWriteArrayList <GameObject>();
	}

	public void tick()
	{
		ListIterator <GameObject> itr = objeto.listIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.next();
			tempObject.tick();
		}
	}

	public void setWorld(WorldLoader world)
	{
		this.world = world;
	}

	public WorldLoader getWorld() { return world; }

	public void render(Graphics g)
	{
		ListIterator <GameObject> itr = objeto.listIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.next();
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object)
	{
		this.objeto.add(object);
	}

	public void removeObject(GameObject object)
	{
		this.objeto.remove(object);
	}
	
}
