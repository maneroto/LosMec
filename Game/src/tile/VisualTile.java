package tile;

import java.awt.image.BufferedImage;

/**
 * Un tile visual se usa para pisos
 * @author Los mec
 *
 */
public abstract class VisualTile extends Tile
{

	public VisualTile(BufferedImage imagen, int iden) {
		super(imagen, iden);
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

}
