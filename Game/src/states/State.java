package states;

import java.awt.Graphics;

import main.GameStateManager;
import images.GameCamera;

public abstract class State {
	
	protected GameStateManager gsm;
	protected GameCamera gameCamera;
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public GameCamera getCamera(){return gameCamera;}

}
