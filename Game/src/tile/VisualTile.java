package tile;

import java.awt.image.BufferedImage;

public abstract class VisualTile extends Tile{

	public VisualTile(BufferedImage imagen, int iden) {
		super(imagen, iden);
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

}
