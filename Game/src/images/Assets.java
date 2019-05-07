package images;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage floor1, bullet, wall1, assault, pistol, shotgun, launcher, minigun, smg, sniper, damage, health, speed;
	
	public static BufferedImage menuBG, p1Wins, p2Wins, settingsBG, howplayBG;
	
	public static BufferedImage[] onChangeAnim, p1Pistol, p1Assault, p1Spawn, p1Shotgun, p1Launcher, p1Minigun, p1Smg, p1Sniper;

	public static void init()
	{
		SpriteSheet floors = new SpriteSheet(ImageLoader.loadImage("/sprites/walls/textures1.jpg"));
		SpriteSheet p1_Pistol = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-pistol.png"));
		SpriteSheet p1_Assault = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-assault.png"));
		SpriteSheet p1_Spawn = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-spawn.png"));
		SpriteSheet p1_Shotgun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-shotgun.png"));
		SpriteSheet p1_Launcher = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-launcher.png"));
		SpriteSheet p1_Minigun = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-minigun.png"));
		SpriteSheet p1_Smg = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-smg.png"));
		SpriteSheet p1_Sniper = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-sniper.png"));
		
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
		
		p1Spawn = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Spawn[i] = p1_Spawn.crop(i*300, 0, 300, 300);
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
		
		floor1 = floors.crop(0, 0, 450, 500);
		wall1 = floors.crop(0, 500, 450, 400);
		bullet = ImageLoader.loadImage("/sprites/weapons/bullet.png");
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
		p1Wins = ImageLoader.loadImage("/sprites/backgrounds/Player1Wins.jpg");
		p2Wins = ImageLoader.loadImage("/sprites/backgrounds/Player2Wins.jpg");
		settingsBG = ImageLoader.loadImage("/sprites/backgrounds/Settings.jpg");
		howplayBG = ImageLoader.loadImage("/sprites/backgrounds/HowPlay.jpg");
	}
	
}
