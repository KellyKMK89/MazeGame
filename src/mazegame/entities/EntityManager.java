package mazegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import mazegame.Handler;

public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	private Player player;
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		
	}

	public void tick(){
		//tick all of the alive Bone entites in entity list
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			if(e.isAlive)
				e.tick();
			else
				entities.remove(e);	//if entity is not alive, remove from list
		}
	}
	
	//render all of the entities
	public void render(Graphics g){
		for(Entity e : entities)
			e.render(g);
	}
	
	//add entities to the entities arraylist
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public EntityManager getEntityManager(){
		return this;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
