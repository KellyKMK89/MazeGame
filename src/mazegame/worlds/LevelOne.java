package mazegame.worlds;

import mazegame.Handler;
import mazegame.entities.Skeleton;
import mazegame.entities.statics.Bone;
import mazegame.entities.statics.Door;
import mazegame.utils.BoneCounter;

/*Adds entities to the level and loads the map tiles from a text file to create Level One*/
public class LevelOne extends World {
	
	public LevelOne(Handler handler) {
		super(handler);
		
		// Add Bone entities
		entityManager.addEntity(new Bone(handler,160,95));
		entityManager.addEntity(new Bone(handler,448,228));
		entityManager.addEntity(new Bone(handler,164,290));
		entityManager.addEntity(new Bone(handler,739,217));
		entityManager.addEntity(new Bone(handler,320,512));
		entityManager.addEntity(new Bone(handler,33,225));
		entityManager.addEntity(new Bone(handler,512,225));
		entityManager.addEntity(new Bone(handler,480,33));
		entityManager.addEntity(new Bone(handler,162,512));
		entityManager.addEntity(new Bone(handler,542,480));
		
		// Add Skeleton entities                       x     y  speed horizontal   
		entityManager.addEntity(new Skeleton(handler, 360, 160, 2.0f, true));
		entityManager.addEntity(new Skeleton(handler, 170, 288, 1.0f, true));
		entityManager.addEntity(new Skeleton(handler, 350, 240, 1.5f, false));
		entityManager.addEntity(new Skeleton(handler, 670, 100, 1.5f, false));
		entityManager.addEntity(new Skeleton(handler, 320, 512, 0.5f, true));
		entityManager.addEntity(new Skeleton(handler, 158, 290, 0.5f, false));
		entityManager.addEntity(new Skeleton(handler, 95, 239, 1.0f, false));
		entityManager.addEntity(new Skeleton(handler, 425, 350, 1.5f, true));
		entityManager.addEntity(new Skeleton(handler, 575, 97, 0.5f, false));
		entityManager.addEntity(new Skeleton(handler, 588, 224, 0.7f, true));
		
		// Add Door entity
		entityManager.addEntity(new Door(handler, 769,510));
		
		//load Tiles from file
		loadWorld("res/Levels/LevelOne.txt");
	}

}
