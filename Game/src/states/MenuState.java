package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import audios.AudioLoader;
import images.Assets;
import main.GameStateManager;

/**
 * Estado que muestra el menú prinicipal
 * @author Los mec
 *
 */
public class MenuState extends State
{
	
	private int currentChoice;
	private String[] options = {
		"Controles",
		"Objetivo",
		"Jugar",
		"Salir"
	};
	private Font font;
	private AudioLoader sweep = new AudioLoader("res\\\\sounds\\\\sweep.wav");
	private AudioLoader enter = new AudioLoader("res\\\\sounds\\\\enter.wav");
	
	public MenuState(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
		

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.menuBG, 0,0,1920, 1080, null);
		
		g.setFont(font);
		
		for (int i = 0; i < options.length; i++)
		{
			if (i == currentChoice)
			{
				g.setColor(Color.BLUE);
			}
			else
			{
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 60 + i * 220, 680);
		}		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		currentChoice = 2;
		font = new Font("Arial", Font.PLAIN, 25);
	}

	public void select()
	{
		if (currentChoice == 0)
		{
			// Controles
			gsm.setSate(GameStateManager.CONTROLS_STATE);
		}
		if (currentChoice == 1)
		{
			// Cómo jugar
			gsm.setSate(GameStateManager.HOWPLAY_STATE);
		}
		if (currentChoice == 2)
		{
			// Jugar
			Random r = new Random();
			int result = r.nextInt(6-3) + 3;
			gsm.setSate(result);
		}
		if (currentChoice == 3)
		{
			// Salir del juego
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER)
		{
			select();
			enter.play();
		}
		
		if (k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A || k == KeyEvent.VK_J)
		{
			currentChoice --;
			if (currentChoice == -1)
			{
				currentChoice = options.length - 1;
			}
			sweep.play();
		}
		
		if (k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D || k == KeyEvent.VK_L)
		{
			currentChoice ++;
			if(currentChoice == options.length)
			{
				currentChoice = 0;
			}
			sweep.play();
		}
	}
	
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
