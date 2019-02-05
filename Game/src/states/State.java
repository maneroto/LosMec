package states;

import main.GameStateManager;
import images.GameCamera;

import java.awt.Graphics;

public abstract class State {
	protected GameStateManager gsm;
	protected GameCamera gameCamera;
	
	public abstract void init();
	public abstract void render(Graphics g);
	public abstract void tick();
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public GameCamera getGameCamera() { return gameCamera; }
}
