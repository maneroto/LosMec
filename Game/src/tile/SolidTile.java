package tile;

import java.awt.image.BufferedImage;

/**
 * El tile sólido se usa para paredes
 * @author Los mec
 *
 */
public abstract class SolidTile extends Tile
{

	public SolidTile(BufferedImage imagen, int iden) {
		super(imagen, iden);
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
}
