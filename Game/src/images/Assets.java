package images;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage floor1, wall1, assault, pistol, shotgun, launcher, minigun, smg, sniper, damage, health, speed;
	
	public static BufferedImage menuBG, p1Wins, p2Wins, howplayBG, settingsBG;
	
	public static BufferedImage[] onChangeAnim, p1Pistol, p1Assault, p1Shotgun, p1Launcher, p1Minigun, p1Smg, p1Sniper;

	public static BufferedImage[] p2Pistol, p2Assault, p2Shotgun, p2Launcher, p2Minigun, p2Smg, p2Sniper;

	public static void init()
	{
		SpriteSheet floors = new SpriteSheet(ImageLoader.loadImage("/sprites/walls/textures1.jpg"));
		SpriteSheet p1_Pistol = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-pistol.png"));
		SpriteSheet p1_Assault = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-assault.png"));
		SpriteSheet p1_Shotgun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-shotgun.png"));
		SpriteSheet p1_Launcher = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-launcher.png"));
		SpriteSheet p1_Minigun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-minigun.png"));
		SpriteSheet p1_Smg = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-smg.png"));
		SpriteSheet p1_Sniper = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-sniper.png"));
		SpriteSheet p2_Pistol = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-pistol.png"));
		SpriteSheet p2_Assault = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-assault.png"));
		SpriteSheet p2_Shotgun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-shotgun.png"));
		SpriteSheet p2_Launcher = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-launcher.png"));
		SpriteSheet p2_Minigun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-minigun.png"));
		SpriteSheet p2_Smg = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-smg.png"));
		SpriteSheet p2_Sniper = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p2/p2-sniper.png"));
		
		p1Pistol = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Pistol[i] = p1_Pistol.crop(i*300, 0, 300, 300);
		}
		
		p1Assault = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Assault[i] = p1_Assault.crop(i*300, 0, 300, 300);
		}
		
		p1Shotgun = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Shotgun[i] = p1_Shotgun.crop(i*300, 0, 300, 300);
		}
		
		p1Launcher = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Launcher[i] = p1_Launcher.crop(i*300, 0, 300, 300);
		}
		
		p1Minigun = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Minigun[i] = p1_Minigun.crop(i*300, 0, 300, 300);
		}
		
		p1Smg = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Smg[i] = p1_Smg.crop(i*300, 0, 300, 300);
		}
		
		p1Sniper = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Sniper[i] = p1_Sniper.crop(i*300, 0, 300, 300);
		}
		
		p2Pistol = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Pistol[i] = p2_Pistol.crop(i*300, 0, 300, 300);
		}
		
		p2Assault = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Assault[i] = p2_Assault.crop(i*300, 0, 300, 300);
		}
		
		p2Shotgun = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Shotgun[i] = p2_Shotgun.crop(i*300, 0, 300, 300);
		}
		
		p2Launcher = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Launcher[i] = p2_Launcher.crop(i*300, 0, 300, 300);
		}
		
		p2Minigun = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Minigun[i] = p2_Minigun.crop(i*300, 0, 300, 300);
		}
		
		p2Smg = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Smg[i] = p2_Smg.crop(i*300, 0, 300, 300);
		}
		
		p2Sniper = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p2Sniper[i] = p2_Sniper.crop(i*300, 0, 300, 300);
		}
		
		floor1 = floors.crop(0, 0, 450, 500);
		wall1 = floors.crop(0, 500, 450, 400);
		assault = ImageLoader.loadImage("/sprites/weapons/assault.png");
		pistol = ImageLoader.loadImage("/sprites/weapons/pistol.png");
		shotgun = ImageLoader.loadImage("/sprites/weapons/shotgun.png");
		launcher = ImageLoader.loadImage("/sprites/weapons/launcher.png");
		minigun = ImageLoader.loadImage("/sprites/weapons/minigun.png");
		sniper = ImageLoader.loadImage("/sprites/weapons/sniper.png");
		smg = ImageLoader.loadImage("/sprites/weapons/smg.png");
		damage = ImageLoader.loadImage("/sprites/powerups/damage.png");
		health = ImageLoader.loadImage("/sprites/powerups/health.png");
		speed = ImageLoader.loadImage("/sprites/powerups/speed.png");
		
		menuBG = ImageLoader.loadImage("/sprites/backgrounds/Menu.jpg");
		settingsBG = ImageLoader.loadImage("/sprites/backgrounds/Settings.jpg");
		howplayBG = ImageLoader.loadImage("/sprites/backgrounds/HowPlay.jpg");
		p1Wins = ImageLoader.loadImage("/sprites/backgrounds/Player1Wins.jpg");
		p2Wins = ImageLoader.loadImage("/sprites/backgrounds/Player2Wins.jpg");
	}
	
}
