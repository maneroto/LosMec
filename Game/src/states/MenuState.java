package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.GameStateManager;
import images.Assets;

public class MenuState extends State{
	
	private int currentChoice;
	private String[] options = {
		"Controles",
		"�C�mo jugar?",
		"Jugar",
		"Salir"
	};
	private Font font;
	
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
			// C�mo jugar
			gsm.setSate(GameStateManager.HOWPLAY_STATE);
		}
		if (currentChoice == 2)
		{
			// Jugar
			gsm.setSate(GameStateManager.FACTORY_STATE);
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
		}
		
		if (k == KeyEvent.VK_UP || k == KeyEvent.VK_A)
		{
			currentChoice --;
			if (currentChoice == -1)
			{
				currentChoice = options.length - 1;
			}
		}
		
		if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_D)
		{
			currentChoice ++;
			if(currentChoice == options.length)
			{
				currentChoice = 0;
			}
		}
	}
	
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
