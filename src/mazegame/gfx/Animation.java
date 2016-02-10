package mazegame.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/* The Animation class contains the logic for cycling though the arrays 
 * of frames used to animate the sprites*/

public class Animation {

	private int speed; 	//speed of animation
	private int index;	//which frame of the animation set
	private long timer, now, lastTime;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames){
		this.frames = frames;
		this.speed = speed;	
	
		index = 0;
		timer = 0;
		now = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick(){
		now = System.currentTimeMillis();
		timer += now - lastTime;
		lastTime = now;
		if(timer>= speed){
			index++;
			timer = 0;
			
			if(index >=frames.length){
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	public BufferedImage getStillFrame(){
		return frames[1];
	}
	
	public void render(Graphics g, int x, int y, int width, int height){
		g.drawImage(frames[index], x, y, width, height, null);
	}

}
