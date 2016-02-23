package mazegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import mazegame.Handler;
import mazegame.gfx.Animation;
import mazegame.gfx.Assets;

/*Contains player movement and animation code*/
public class Player extends Creature{

	//Animations
	private Animation animDown, animUp, animRight, animLeft;
	
	private int lastMove = 0;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// Define Player collision bounds
		bounds.x = 6;
		bounds.y = 10;
		bounds.width = 20;
		bounds.height = 22;
		
		// Initialise Animations
		animDown = new Animation(150, Assets.playerDown);
		animUp = new Animation(150, Assets.playerUp);
		animLeft = new Animation(150, Assets.playerLeft);
		animRight = new Animation(150, Assets.playerRight);
	}
	
	@Override
	public void tick() {		
		//Update the animation frames
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();

		getInput();
		move();
	}
	
	// Get the keyboard input
	private void getInput(){
		xMove = 0.0f;	 
		yMove = 0.0f;

		if(handler.getKeyManager().left)
			xMove += -speed;
		if(handler.getKeyManager().right)
			xMove += speed;
		if(xMove == 0)	//prevent diagonal movement
		{
			if(handler.getKeyManager().up)
				yMove += -speed;
			if(handler.getKeyManager().down)
				yMove += speed;
		}		
	}

	/* Player movement code. Prevents diagonal movement. If the player is standing still, 
	 * return only the standing frame of player facing in the direction last moved.*/
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			lastMove = 1;
			return animLeft.getCurrentFrame();		
		}
		else if(xMove > 0){
			lastMove = 2;
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0){
			lastMove = 3;
			return animUp.getCurrentFrame();
		}
		else if (yMove > 0){
			lastMove = 4;
			return animDown.getCurrentFrame();
		}
		else
		{
			if(lastMove == 1)
				return animLeft.getStillFrame();
			else if(lastMove == 2)
				return animRight.getStillFrame();
			else if(lastMove == 3)
				return animUp.getStillFrame();
			else if(lastMove == 4)
				return animDown.getStillFrame();
		}
		return animDown.getStillFrame(); //the starting player frame
			
	}			
	
	@Override
	public void render(Graphics g) {
		//takes x and y from base class Entity - convert floats to int
		g.drawImage(getCurrentAnimationFrame(), (int)x, (int) y, width, height, null);	

	//		if uncommented, the below code will show the player collision box as a red rectangle
	//		g.setColor(Color.red);
	//		g.fillRect((int) (x + bounds.x ),(int) (y + bounds.y ),bounds.width, bounds.height);
	}

	public Rectangle getBounds() {
		return this.bounds;
	}
	
}
