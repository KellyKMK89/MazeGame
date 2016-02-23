package mazegame.worlds;

import java.awt.Graphics;
import mazegame.Handler;
import mazegame.entities.EntityManager;
import mazegame.entities.Player;
import mazegame.tiles.Tile;
import mazegame.utils.Counter;
import mazegame.utils.Utils;

/* World class is the base class for all of the levels in the game, it loads the tiles 
 * from a text file into the Tile array and instantiates the Entity Manager*/
public abstract class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;		//set inside World.text file
	private int[][] tiles;			//store the int ids of tiles
	private Counter counter;
	
	protected EntityManager entityManager;
	
	public World(Handler handler){	//load level from a file
		this.handler = handler;
		//Add the player to the entity manager
		entityManager = new EntityManager(handler, new Player(handler, 30,30)); //730,510
		this.counter = new Counter();
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		// Efficiency code to render only visible tiles to screen 
		for(int y = 0; y < height; y++){	
			for(int x = 0; x < width; x++){
				getTile(x,y).render(g, x * Tile.TILEWIDTH,y * Tile.TILEHEIGHT);
			}
		}
		entityManager.render(g);		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.floorTile;	//prevent errors
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.floorTile;
		return t;
	}
	
	protected void loadWorld(String path){	//was protected
		String level = Utils.loadFileAsString(path);
		String[] tokens = level.split("\\s+");	//split on any whitespace
		width = Utils.parseInt(tokens[0]);		// read first 4 lines of file
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0;x<width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+ 4]);	//adds the extra lines
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
