package mazegame.entities.statics;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.entities.Entity;

/* A Static entity does not move, (eg Tree, rock) therefore has no move methods */
public class StaticEntity extends Entity{
	
	public StaticEntity(Handler handler, float x, float y , int width, int height){
		super(handler, x, y, width, height);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}
	
}
