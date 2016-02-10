package mazegame.utils;

import mazegame.audio.SoundClip;

public class Counter {

	private SoundClip levelSound;
	public static int LEVEL = 1;
	
	public Counter(){
		LEVEL = 1;
		levelSound = new SoundClip("/Sounds/NextLevel.wav");
		levelSound.play();
	}
	
	public void resetLevel(){
		LEVEL = 1;
	}
	
	
}
