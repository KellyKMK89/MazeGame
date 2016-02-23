package mazegame.worlds;

import mazegame.Handler;
import mazegame.entities.Skeleton;
import mazegame.entities.Zombie;
import mazegame.entities.statics.Bone;
import mazegame.entities.statics.Door;
import mazegame.utils.BoneCounter;

/*Adds entities to the level and loads the map tiles from a text file to create Level Three*/
public class LevelThree extends World {
	
	public LevelThree(Handler handler) {
		super(handler);
		
		
		// Add Bone entities
		entityManager.addEntity(new Bone(handler,350,32));
		entityManager.addEntity(new Bone(handler,225,288));
		entityManager.addEntity(new Bone(handler,575,160));
		entityManager.addEntity(new Bone(handler,605,415));
		entityManager.addEntity(new Bone(handler,608,482));
		entityManager.addEntity(new Bone(handler,95,95));
		entityManager.addEntity(new Bone(handler,575,352));
		entityManager.addEntity(new Bone(handler,162,385));
		entityManager.addEntity(new Bone(handler,670,97));
		entityManager.addEntity(new Bone(handler,450,160));
		
		// Add Skeleton entities                    x     y  speed horizontal   
		entityManager.addEntity(new Zombie(handler, 32, 167, 1.5f, false));
		entityManager.addEntity(new Zombie(handler, 235, 160, 3.0f, true));
		entityManager.addEntity(new Zombie(handler, 224, 368, 3.0f, false));
		entityManager.addEntity(new Zombie(handler, 450, 96, 2.0f, true));
		entityManager.addEntity(new Zombie(handler, 510, 270, 1.0f, false));
		entityManager.addEntity(new Zombie(handler, 545, 415, 0.5f, false));
		entityManager.addEntity(new Zombie(handler, 678, 415, 0.5f, true));
		entityManager.addEntity(new Zombie(handler, 455, 160, 1.0f, true));
		entityManager.addEntity(new Zombie(handler, 262, 255, 1.5f, true));
		entityManager.addEntity(new Zombie(handler, 390, 96, 2.0f, true));
		
		// Add Door entity
		entityManager.addEntity(new Door(handler, 769,510));
		
		//load Tiles from file
		loadWorld("res/Levels/LevelThree.txt");
	}

}
