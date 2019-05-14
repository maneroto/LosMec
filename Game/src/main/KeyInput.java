package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Esta clase lee el input del usuario y usa el patr�n de dise�o COMMAND
 * @author Los mec
 *
 */
public class KeyInput implements KeyListener
{
	
	GameStateManager gsm;
	
	public KeyInput(GameStateManager gsm)
	{
		this.gsm = gsm;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();	
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		gsm.keyPressed(key);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		gsm.keyReleased(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
