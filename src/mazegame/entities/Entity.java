package mazegame.entities;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Rectangle;
import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.entities.statics.Bone;
//import mazegame.entities.statics.Door;
//import mazegame.utils.Counter;
import mazegame.utils.LifeCounter;
import mazegame.utils.BoneCounter;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;	//floats give smoother movements than int
	protected int width, height;
	protected Rectangle bounds;
	public boolean isAlive = true;
	private SoundClip boneSound;
	private SoundClip dieSound;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0,0,width,height);	//size of collision rectangle
		
		//load sounds
		boneSound = new SoundClip("/Sounds/Collect.wav");
		dieSound = new SoundClip("/Sounds/LifeLost.wav");
	}

	
	// Where the entity will update all of its variables
	public abstract void tick();
	
	//where the entity willd draw itself to the screen
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		boolean collided = false;
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				//entity won't check for collisions against itself
				continue;
			}
				
			//check for collision with Bone entity
			
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				if(e instanceof Bone){
					collided = true;
					e.isAlive = false;
					BoneCounter.BONES_COLLECTED +=1;
					boneSound.play();
				}
				else if(e instanceof Monster){
					LifeCounter lc = new LifeCounter();;	//lose a life
					dieSound.play();
					try {
						Thread.sleep(1000); //pause for a second, play lose life sound
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					//reset player position	
					handler.getWorld().getEntityManager().getPlayer().setY(30);
					handler.getWorld().getEntityManager().getPlayer().setX(30);
				}
			}
		}
		return collided;
	}
	
	//return the bounding rectangle around the entity
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	
}
