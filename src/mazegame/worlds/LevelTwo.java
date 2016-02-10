package mazegame.worlds;

import mazegame.Handler;
import mazegame.entities.Mummy;
import mazegame.entities.statics.Bone;
import mazegame.entities.statics.Door;

/*Adds entities to the level and loads the tiles from a text file*/
public class LevelTwo extends World {
	
	public LevelTwo(Handler handler) {	
		super(handler);
		
		// Add Bone entities
		entityManager.addEntity(new Bone(handler, 230, 420));
		entityManager.addEntity(new Bone(handler, 103, 225));
		entityManager.addEntity(new Bone(handler, 705, 95));
		entityManager.addEntity(new Bone(handler, 480, 420));
		entityManager.addEntity(new Bone(handler, 290, 288));
		entityManager.addEntity(new Bone(handler, 512, 160));
		entityManager.addEntity(new Bone(handler, 669, 288));
		entityManager.addEntity(new Bone(handler, 672, 353));
		entityManager.addEntity(new Bone(handler, 258, 33));
		entityManager.addEntity(new Bone(handler, 260, 160));
		
		// Add Mummy entities
		entityManager.addEntity(new Mummy(handler, 360, 160, 2.0f, true));
		entityManager.addEntity(new Mummy(handler, 160, 288, 2.0f, false));
		entityManager.addEntity(new Mummy(handler, 353, 240, 1.0f, false));
		entityManager.addEntity(new Mummy(handler, 690, 416, 2.0f, true));
		entityManager.addEntity(new Mummy(handler, 640, 100, 1.0f, false));
		entityManager.addEntity(new Mummy(handler, 560, 287, 0.5f, true)); 
		entityManager.addEntity(new Mummy(handler, 228, 415, 1.5f, true));
		entityManager.addEntity(new Mummy(handler, 543, 285, 1.5f, false));
		entityManager.addEntity(new Mummy(handler, 295, 287, 1.0f, true));
		entityManager.addEntity(new Mummy(handler, 545, 335, 1.0f, false));
		
		// Add the Door entity
		entityManager.addEntity(new Door(handler, 769, 510));
		
		//load tiles from file
		loadWorld("res/Levels/LevelTwo.txt");
	}

}
