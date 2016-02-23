package mazegame.utils;

/*Keep track of the number of bones collected per level*/
public class BoneCounter {
	
	public static int BONES_COLLECTED;

	public BoneCounter(){
		BONES_COLLECTED = 0;
	}
	
	public void resetCounter(){
		BONES_COLLECTED = 0;
	}
	
	
}
