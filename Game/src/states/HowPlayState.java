package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.GameStateManager;
import images.Assets;

public class HowPlayState extends State{
	
	private String message = "Presiona enter para continuar";
	private Font font;

	public HowPlayState(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
		

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.howplayBG, 0,0,1920, 1080, null);
		
		g.setFont(font);
		
		g.setColor(Color.WHITE);
		
		g.drawString(message, 150, 680);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		font = new Font("Arial", Font.PLAIN, 25);
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER)
		{
			gsm.setSate(GameStateManager.MENU_STATE);
		}
	}


	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
