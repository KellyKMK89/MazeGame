package mazegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import mazegame.Handler;
import mazegame.tiles.Tile;

/* The Monster class is the base class for all monster entites.
 * Contains the basic movement and collision code for all monsters*/

public abstract class Monster extends Creature {
	
	//Animations
	protected boolean left;
	protected boolean up;
	protected float speed;

	public Monster(Handler handler, float x, float y, int width, int height, float speed) {
		super(handler, x, y, width, height);
		
		//collision box of monster entity
		bounds.x = 4;
		bounds.y = 4;
		bounds.width = 24;
		bounds.height = 24;
		
		this.speed = speed;
		
	}
	@Override
	public abstract void tick();
	
	public void moveRight(){
		xMove = speed;
		if(xMove > 0){ //Right
			int tx = (int) (x + xMove + bounds.x + bounds.width) /Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width -1 ;
				left = true;
			}
		}
	}
	
	public void moveLeft(){
		xMove = -speed;
		if(xMove < 0){ //Left
			int tx = (int) (x + xMove + bounds.x) /Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			else{
				x = tx * Tile.TILEWIDTH + Tile.TILEHEIGHT - bounds.x;
				left = false;
			}
		}
	}
	
	public void moveUp(){
		yMove = -speed;
		if(yMove < 0){ //Up
			int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && 
			   !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
			else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
				up = false;
			}
		}
	}
	
	public void moveDown(){	
		yMove = speed;
		if(yMove > 0){ //Down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && 
			   !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
			else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height -1 ;
				up = true;
			}
		}
	}
	
	protected abstract BufferedImage getCurrentAnimationFrame();
	
	@Override
	public abstract void render(Graphics g);
	
	public Rectangle getBounds(){
		return this.bounds;
	}

}
