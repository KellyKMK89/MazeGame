package mazegame.states;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.worlds.LevelOne;

public class LevelOneState extends State{

	private LevelOne levelOne;
	private BoneCounter boneCounter;
	private SoundClip l1Music;
	public LevelOneState(Handler handler) {
		super(handler);
		levelOne = new LevelOne(handler);
		handler.setWorld(levelOne);
		boneCounter = new BoneCounter();
		l1Music = new SoundClip("/Sounds/Level1Music.wav");
		l1Music.setLooping(true);
		l1Music.play();
	}

	public void tick() {
		levelOne.tick();
		float x = handler.getWorld().getEntityManager().getPlayer().getX();
		float y = handler.getWorld().getEntityManager().getPlayer().getY();
		if(x >= 725 && y >= 500 && BoneCounter.BONES_COLLECTED == 10){		
			try {
				Thread.sleep(1000); 
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			l1Music.stop();
			Counter.LEVEL = 2;
			
		}
	}
	
	@Override
	public void render(Graphics g) {
		levelOne.render(g);
	}
}
