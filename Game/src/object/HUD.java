package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.GameLoop;

/**
 * Esta clase crea el HUD que son barras de vida básicamente
 * @author Los mec
 *
 */
public class HUD
{
	private int vidaP1, vidaP2, greenValueP1, greenValueP2;
	private Font font;
	
	public HUD() 
	{
		this.font = new Font("Arial", Font.BOLD, 15);
		greenValueP1 = 255;
		greenValueP2 = 255;
	}
	
	public void tick() 
	{
		vidaP1 = (int) GameLoop.clamp(vidaP1, 0, 100);
		greenValueP1 = (int) GameLoop.clamp(greenValueP1, 0, 255);
		greenValueP1 = vidaP1 * 2;
		vidaP2 = (int) GameLoop.clamp(vidaP2, 0, 100);
		greenValueP2 = (int) GameLoop.clamp(greenValueP2, 0, 255);
		greenValueP2 = vidaP2 * 2;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 960, 1920, 120);
		g.setFont(font);
		g.setColor(new Color(120, greenValueP1, 0));
		g.fillRect(40, 980, vidaP1 * 9, 80);
		g.setColor(Color.WHITE);
		g.drawRect(40, 980, 900, 80);
		g.setColor(new Color(120, greenValueP2, 0));
		g.fillRect(980, 980, vidaP2 * 9, 80);
		g.setColor(Color.WHITE);
		g.drawRect(980, 980, 900, 80);
	}
	
	public void setVidaP1(int vidaP1) {
		this.vidaP1 = vidaP1;
	}
	
	public void setVidaP2(int vidaP2) {
		this.vidaP2 = vidaP2;
	}
	
	public int getVidaP1()
	{
		return vidaP1;
	}
	public int getVidaP2()
	{
		return vidaP2;
	}
}