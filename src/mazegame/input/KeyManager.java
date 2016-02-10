package mazegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* KeyManager gets all key presses from the keyboard and stores
 * them in a boolean array*/

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, start, pause;
	public boolean gamePaused, unPause;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		start = keys[KeyEvent.VK_SPACE];
		pause = keys[KeyEvent.VK_P];
		unPause = keys[KeyEvent.VK_U];

	}
	
	@Override
	public void keyPressed(KeyEvent e) {	// all keys on keyboard have a unique numeric code
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
