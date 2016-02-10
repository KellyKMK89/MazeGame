package mazegame.states;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.worlds.LevelThree;

public class LevelThreeState extends State{

	private LevelThree levelThree;
	private BoneCounter boneCounter;
	private SoundClip l3Music;
	
	public LevelThreeState(Handler handler) {
		super(handler);
		levelThree = new LevelThree(handler);
		handler.setWorld(levelThree);
		boneCounter = new BoneCounter();
		
		l3Music = new SoundClip("/Sounds/Level3Music.wav");
		l3Music.setLooping(true);
		l3Music.play();
	}

	public void tick() {
		levelThree.tick();
		float x = handler.getWorld().getEntityManager().getPlayer().getX();
		float y = handler.getWorld().getEntityManager().getPlayer().getY();
		if(x >= 725 && y >= 500 && BoneCounter.BONES_COLLECTED == 10){  
			Counter.LEVEL = 4;
			l3Music.stop();
		}
	}

	@Override
	public void render(Graphics g) {
		levelThree.render(g);
	}
}
