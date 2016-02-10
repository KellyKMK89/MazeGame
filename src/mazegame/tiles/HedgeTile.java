package mazegame.tiles;

import mazegame.gfx.Assets;

public class HedgeTile extends Tile{

	public HedgeTile(int id) {
		super(Assets.hedge, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
