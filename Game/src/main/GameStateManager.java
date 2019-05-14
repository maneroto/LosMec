package main;

import java.awt.Graphics;
import java.util.ArrayList;

import audios.AudioLoader;
import states.State;

/**
 * Esta clase controla los diferentes estados dentro del juego
 * @author Los mec
 *
 */

public class GameStateManager
{
	
	private ArrayList <State> gameStates;
	private int currentState;
	private AudioLoader soundtrack;
	
	private static int numStates = 8;
	public static final int PLAYER1WINS_STATE = numStates -2;
	public static final int PLAYER2WINS_STATE = numStates -1;
	public static final int MENU_STATE = 0;
	public static final int HOWPLAY_STATE = 1;
	public static final int CONTROLS_STATE = 2;
	public static final int FACTORY_STATE = 3;
	public static final int LABORATORY_STATE = 4;
	public static final int LAVA_STATE = 5;
	
	public GameStateManager()
	{
		soundtrack = new AudioLoader("res\\\\soundtrack\\\\soundtrack.wav");
		soundtrack.loop();
		
		gameStates = new ArrayList <State> ();
		
		currentState = MENU_STATE;	
		gameStates.add(new states.MenuState(this));
		gameStates.add(new states.HowPlayState(this));
		gameStates.add(new states.ControlsState(this));
		
		gameStates.add(new states.FactoryState(this));
		gameStates.add(new states.LaboratoryState(this));
		gameStates.add(new states.LavaState(this));
		
		gameStates.add(new states.P1VictoryState(this));
		gameStates.add(new states.P2VictoryState(this));
	}
	
	public void tick()
	{
		gameStates.get(currentState).tick();
	}
	
	public void render(Graphics g)
	{
		gameStates.get(currentState).render(g);
	}
	
	public void keyPressed(int k)
	{
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k)
	{
		gameStates.get(currentState).keyReleased(k);
	}
	
	public void setSate(int state)
	{
		currentState = state;
		if (currentState > numStates) currentState = MENU_STATE;
		gameStates.get(currentState).init();
	}
	
	public int getState()
	{
		return currentState;
	}
}
