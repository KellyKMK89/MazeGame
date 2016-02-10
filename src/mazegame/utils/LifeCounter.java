package mazegame.utils;

public class LifeCounter {

	private static int lives;
	
	public LifeCounter(){
		lives++;
	}
    public static void printLives(){ //static method
        System.out.println("Number of instances created so far is: " + lives);
    }  
    public static int getLives(){
    	return lives;
    }
    public static void resetLives(){
    	lives = 0;
    }
	
}
