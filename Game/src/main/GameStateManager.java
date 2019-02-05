package main;

import states.State;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager {
	private ArrayList<State> gameStates;
	private int currentState;
	
	private static int numStates = 0;
	
	public static final int MENU_STATE = 0;
	public GameStateManager()
	{
		gameStates = new ArrayList <State> ();
		
		currentState = MENU_STATE;
		
		//gameStates.add(new MenuState(this))
	}
	
	public void tick()
	{
		gameStates.get(currentState).tick();
	}
	public void render(Graphics g)
	{
		gameStates.get(currentState).render(g);
	}
	public void kePressed(int k)
	{
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k)
	{
		gameStates.get(currentState).keyReleased(k);
	}
	public void setState(int newState)
	{
		currentState = newState;
		if (currentState > numStates) currentState = MENU_STATE;
		gameStates.get(currentState).init();
	}
	public int getCurrentState() { return currentState; }
}
