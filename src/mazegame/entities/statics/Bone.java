package mazegame.entities.statics;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.entities.Entity;
import mazegame.gfx.Assets;
import mazegame.tiles.Tile;

public class Bone extends StaticEntity{

	public Bone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);	//last 2 params resize the image
		
		bounds.x =10;
		bounds.y = 10;
		bounds.height = 22;
		bounds.width = 22;
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bone,(int)x, (int)y, width, height, null);
	}
	

}
