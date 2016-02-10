package mazegame;

import mazegame.entities.Player;
import mazegame.input.KeyManager;
import mazegame.utils.BoneCounter;
import mazegame.worlds.World;

/* Handler Class - one object - the Handler object - allows
 * access to other common objects like Game, World and KeyManager*/

public class Handler {

	private Game game;
	private World world;
	private BoneCounter boneCounter;
	
	public Handler(Game game){
		this.game = game;
	}
	
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}

	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public Game getGame(){
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}


	public BoneCounter getCounter() {
		return boneCounter;
	}
	
	

}
