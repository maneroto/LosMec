package tile;

import java.awt.image.BufferedImage;

public abstract class SolidTile extends Tile{

	public SolidTile(BufferedImage imagen, int iden) {
		super(imagen, iden);
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
}
