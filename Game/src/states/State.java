package states;

import java.awt.Graphics;

import main.GameStateManager;

/**
 * Clase abstracta de los estados, reciben un key input
 * @author Los mec
 *
 */
public abstract class State 
{
	
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);

}
