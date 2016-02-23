package mazegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mazegame.Handler;
import mazegame.gfx.Animation;
import mazegame.gfx.Assets;

/* Contains the Zombie animations and movement code*/
public class Zombie extends Monster{
	
	//Animations
	private Animation animDown, animUp, animRight, animLeft;
	private boolean horizontal;

	public Zombie(Handler handler, float x, float y, float speed, Boolean horizontal) {
		super(handler, x, y, 32,32,speed);

		//Initialise Animations
		animDown = new Animation(200, Assets.zombieDown);
		animUp = new Animation(200, Assets.zombieUp);
		animLeft = new Animation(200, Assets.zombieLeft);
		animRight = new Animation(200, Assets.zombieRight);
		
		this.horizontal = horizontal;
		this.speed = speed;
		
		if(horizontal == true){
			this.left = true;
		}
		else{
			this.up = true;
		}
	}
	
	@Override
	public void tick(){
		// Update animation frames
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		moveMonster();
	}
	
	// The monster will reverse direction if it hits a wall
	public void moveMonster(){
		if(this.horizontal == true){
			if(left == true){
				moveLeft();
			}
			else{
				moveRight();
			}
		}
		else{
			if(up == true){
				moveUp();
			}
			else{	
				moveDown();
			}
		}
	}
	
	// Set the animation frames depending on which direction the entity is facing
	protected BufferedImage getCurrentAnimationFrame(){

		if(xMove < 0){
			return animLeft.getCurrentFrame();		
		}
		else if(xMove > 0){
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0){
			return animUp.getCurrentFrame();
		}
		else if (yMove > 0){
			return animDown.getCurrentFrame();
		}
		return animLeft.getStillFrame();
	}
	
	
	@Override
	public void render(Graphics g){
		g.drawImage(getCurrentAnimationFrame(), (int)x, (int) y, width, height, null);	//takes x and y from entity - convert floats to int
	}
	
	public Rectangle getBounds(){
		return this.bounds;
	}

}
