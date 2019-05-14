package images;

import java.awt.image.BufferedImage;

/**
 * Esta clase permite hacer las animaciones de los sprites
 * @author Los mec
 *
 */
public class Animation 
{
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed;
		this.frames = frames;
		index = 0;
		lastTime = System.currentTimeMillis();
		timer = 0;
	}
	
	public void setCurrentFrame(int index)
	{
		this.index=index;
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}

	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed)
		{
			index ++;
			timer = 0;
			if (index >= frames.length) index = 0;
		}
	}
}
