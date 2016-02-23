package mazegame.entities.statics;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.gfx.Assets;
import mazegame.tiles.Tile;

/*Door is a static entity to be drawn at the exit of the level*/
public class Door extends StaticEntity{

	public Door(Handler handler, float x, float y) {
		super(handler, x, y, 32, Tile.TILEHEIGHT);
		
		bounds.x = -6;
		bounds.y = 0;
		bounds.height = 32;
		bounds.width = 40;
	}
	
	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.door,(int)x, (int)y, width, height, null);
	}

}
