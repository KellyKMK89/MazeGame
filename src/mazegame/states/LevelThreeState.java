package mazegame.states;

import java.awt.Graphics;
import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.utils.LifeCounter;
import mazegame.worlds.LevelThree;

/*Create the game state for Level Three*/
public class LevelThreeState extends State{

	private LevelThree levelThree;
	private BoneCounter boneCounter;
	//removed level music to reduce size of download
	//private SoundClip l3Music;
	
	public LevelThreeState(Handler handler) {
		super(handler);
		levelThree = new LevelThree(handler);
		handler.setWorld(levelThree);
		boneCounter = new BoneCounter();
		
		//l3Music = new SoundClip("/Sounds/Level3Music.wav");
		//l3Music.setLooping(true);
		//l3Music.play();
	}

	public void tick() {
		levelThree.tick();
		if(LifeCounter.getLives() == 3){
			//l3Music.stop();
		}
		float x = handler.getWorld().getEntityManager().getPlayer().getX();
		float y = handler.getWorld().getEntityManager().getPlayer().getY();
		if(x >= 725 && y >= 500 && BoneCounter.BONES_COLLECTED == 10){  
			try {
				Thread.sleep(1000); 
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Counter.LEVEL = 4;
			//l3Music.stop();
		}
	}

	@Override
	public void render(Graphics g) {
		levelThree.render(g);
	}
}
