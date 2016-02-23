package mazegame.states;

import java.awt.Graphics;
import mazegame.Handler;
import mazegame.utils.Counter;

/*The base class State which is inherited by all game states*/
public abstract class State {

	//State manager - holds the current state of the game
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public static State getState() {
		return currentState;
	}

	public static void setState(State currentState) {
		State.currentState = currentState;
	}

	
}
