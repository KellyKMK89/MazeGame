package mazegame.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;	//don't remove
import mazegame.utils.LifeCounter;

/*STAT BAR shows player lives, bones collected and level number*/

public class StatBar{

	public int level = 1; 
	private int lives; 
	private int bones;

	public void tick() {
		//update the Stats
		if(LifeCounter.getLives()==0)
			lives = 3;
		else if(LifeCounter.getLives() ==1)
			lives = 2;
		else if(LifeCounter.getLives() ==2)
			lives = 1;
		bones = BoneCounter.BONES_COLLECTED;
	}


	public void render(Graphics g) {
		// Define colours
		Color black = new Color(60,60,60);		
		Color grey = new Color(170,170,170);
		Color tan = new Color(237,217,157);
		Color green = new Color(200,230,150);
		
		// Change the stat bar colour depending on the level
		switch (level){
			case 1:
				g.setColor(grey);
				break;
			case 2:
				g.setColor(tan);
				break;
			case 3:
				g.setColor(green);
				break;
			default:
				g.setColor(black);
		}
		
		g.fillRect(12,555,775,35);
		Font mainFont = new Font("Lucida Sans Demibold", Font.BOLD, 25);
		g.setColor(black);
		g.setFont(mainFont);
		g.drawString("LIVES:  " + lives, 90, 582);
		g.drawString("LEVEL: " + level, 320, 582);
		g.drawString("BONES: " + bones + "/10", 540, 582);
		
	}
	
	public void resetStats(){
		this.level = 1;
		this.bones = 0;
		this.lives = 1;
	}
	

}
