package mazegame.states;

import java.awt.Graphics;
import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.utils.LifeCounter;
import mazegame.worlds.LevelOne;

/*Create the game state for Level One*/
public class LevelOneState extends State{

	private LevelOne levelOne;
	private BoneCounter boneCounter;
	//removed level music to reduce size of download
	//private SoundClip l1Music;
	public LevelOneState(Handler handler) {
		super(handler);
		levelOne = new LevelOne(handler);
		handler.setWorld(levelOne);
		boneCounter = new BoneCounter();
		//l1Music = new SoundClip("/Sounds/Level1Music.wav");
		//l1Music.setLooping(true);
		//l1Music.play();
	}

	public void tick() {
		levelOne.tick();
		if(LifeCounter.getLives() == 3){
			//l1Music.stop();
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
			//l1Music.stop();
			Counter.LEVEL = 2;
		}
	}
	
	@Override
	public void render(Graphics g) {
		levelOne.render(g);
	}
}
