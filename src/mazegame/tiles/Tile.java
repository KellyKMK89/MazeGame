package mazegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static stuff here
	
	public static Tile[] tiles = new Tile[256];
	public static Tile floorTile = new FloorTile(0);
	public static Tile wallTile = new WallTile(1);
	public static Tile sandTile = new SandTile(2);
	public static Tile stoneTile = new StoneTile(3);
	public static Tile grassTile = new GrassTile(4);
	public static Tile hedgeTile = new HedgeTile(5);
	
	//class
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

	protected BufferedImage texture;
	protected final int id;	//unique number to identify tiles should never change
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;	
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT,null);

	}
	
	public int getID(){
		return id;
	}
	
	
	public boolean isSolid(){	//is tile solid
		return false;
	}
}
