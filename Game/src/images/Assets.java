package images;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage floor1, depPlayer, wall1;
	
	public static BufferedImage[] onChangeAnim;

	public static void init()
	{
		SpriteSheet floors = new SpriteSheet(ImageLoader.loadImage("/sprites/walls/textures1.jpg"));
		floor1 = floors.crop(0, 0, 450, 500);
		wall1 = floors.crop(0, 500, 450, 400);
		depPlayer = ImageLoader.loadImage("/sprites/characters/p1/p1.png");
	}
	
}
