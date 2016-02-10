
package mazegame;
import mazegame.display.*;

public class Launcher {

    public static void main(String[] args) {
        
        Game game = new Game("Tile Game!", 800,600); //set title and screen resolution
        game.start();

    }
    
}
