package mazegame.states;

import java.awt.Graphics;

import mazegame.Handler;
import mazegame.audio.SoundClip;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.worlds.LevelTwo;

public class LevelTwoState extends State{

	private LevelTwo levelTwo;
	private BoneCounter boneCounter;
	private SoundClip l2Music; 
	
	public LevelTwoState(Handler handler) {
		super(handler);

		levelTwo = new LevelTwo(handler);
		handler.setWorld(levelTwo);
		boneCounter = new BoneCounter();
		
		l2Music = new SoundClip("/Sounds/Level2Music.wav");
		l2Music.setLooping(true);
		l2Music.play();

	}

	@Override
	public void tick() {
		levelTwo.tick();
		float x = handler.getWorld().getEntityManager().getPlayer().getX();
		float y = handler.getWorld().getEntityManager().getPlayer().getY();
		if(x >= 725 && y >= 500 && BoneCounter.BONES_COLLECTED == 10){
			l2Music.stop();
		}

	}

	@Override
	public void render(Graphics g) {
		levelTwo.render(g);
	}

}
