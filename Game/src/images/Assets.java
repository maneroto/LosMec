package images;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage floor1, bullet, wall1;
	
	public static BufferedImage[] onChangeAnim, p1Pistol;

	public static void init()
	{
		SpriteSheet floors = new SpriteSheet(ImageLoader.loadImage("/sprites/walls/textures1.jpg"));
		SpriteSheet p1_Pistol = new SpriteSheet(ImageLoader.loadImage("/sprites/characters/p1/p1-pistol.png"));
		
		p1Pistol = new BufferedImage[4];
		for (int i = 0; i < 4; i ++)
		{
			p1Pistol[i] = p1_Pistol.crop(i*300, 0, 300, 300);
		}
		
		floor1 = floors.crop(0, 0, 450, 500);
		wall1 = floors.crop(0, 500, 450, 400);
		bullet = ImageLoader.loadImage("/sprites/weapons/bullet.png");
	}
	
}
