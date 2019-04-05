package main;

import states.State;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList <State> gameStates;
	private int currentState;
	
	private static int numStates = 1;
	public static final int LEVEL1_STATE = 0;
	
	public GameStateManager()
	{
		gameStates = new ArrayList <State> ();
		
		currentState = LEVEL1_STATE;	
		gameStates.add(new states.Level1State(this));
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
		if (currentState > numStates) currentState = LEVEL1_STATE;
		gameStates.get(currentState).init();
	}
	
	public int getState()
	{
		return currentState;
	}
}
