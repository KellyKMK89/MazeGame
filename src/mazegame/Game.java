package mazegame;

import mazegame.audio.SoundClip;
import mazegame.display.Display;
import mazegame.entities.StatBar;
import mazegame.gfx.Assets;
import mazegame.input.KeyManager;
import mazegame.states.LevelOneState;
import mazegame.states.LevelThreeState;
import mazegame.states.LevelTwoState;
import mazegame.states.MenuState;
import mazegame.states.GameOverState;
import mazegame.states.GameWonState;
import mazegame.states.State;
import mazegame.utils.BoneCounter;
import mazegame.utils.Counter;
import mazegame.utils.LifeCounter;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/* The Game class initializes the Game States and Stats Bar.
 * Manages the levels and contains the Main loop which ticks and
 * renders all objects in the game.
 */
public class Game implements Runnable{
    
    private Display display;
    private int width;
    private int height;
    public String title;
    
    private boolean running = false;
    public Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State menuState;
    private State levelOneState;
    private State levelTwoState;
    private State levelThreeState;
    private State gameOverState;
    private State gameWonState;
    
    private Boolean gameStarted = false;
    public int gamestate;
    
    //Stats Bar 
    private StatBar statBar;
    
    //Input
    private KeyManager keyManager;
    
    //Handler
    private Handler handler;

    //CONSTRUCTOR
    public Game(String title, int width, int height){
       this.width = width;
       this.height = height;
       this.title = title;
       keyManager = new KeyManager();      
    }
    
    public void init(){		//order of statements is important
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);	// adds the keylistener to the JFrame
        Assets.init();
        
        handler = new Handler(this);
        menuState = new MenuState(handler);
        statBar = new StatBar();

        if(!gameStarted)
        	State.setState(menuState);
    }
    
    private void stateManager(){
    	if(State.getState().equals(gameOverState) || State.getState().equals(menuState) || State.getState().equals(gameWonState)){
	    	if(keyManager.start){
	    		gameStarted = true;
	    		levelOneState = new LevelOneState(handler);
	    		State.setState(levelOneState);
	    	}	
    	}
    	
    	if(Counter.LEVEL == 2){
    		levelTwoState = new LevelTwoState(handler);
    		State.setState(levelTwoState);
    		statBar.level = 2;
    	}
    	
    	if(Counter.LEVEL == 3){
    		levelThreeState = new LevelThreeState(handler);
    		statBar.level = 3;
    		State.setState(levelThreeState);
    	}
    	
    	if(Counter.LEVEL == 4){
    		gameWonState = new GameWonState(handler);
    		State.setState(gameWonState);
    		statBar.resetStats();
    		LifeCounter.resetLives();
    	}
    	
    	if(LifeCounter.getLives() == 3){	//Game Over
    		gameOverState = new GameOverState(handler);
    		statBar.resetStats();
    		State.setState(gameOverState);
    		LifeCounter.resetLives();
    	}
    	
    	if(State.getState() != null){
    		State.getState().tick();
    	}
    }
   
    private void tick(){	 
    	keyManager.tick();	
    	stateManager();
    }
    
    //Paint objects to the screen
    private void render(){
        bs = display.getCanvas().getBufferStrategy();   //buffer strategy sets the buffers
        if(bs== null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);	//clear screen - without this line screen flickers
        
        //renders the current State
        if(State.getState() != null){
        	State.getState().render(g);
        }
        //draw stats bar
        if(State.getState() != menuState && State.getState()!= gameOverState && State.getState() != gameWonState){
        	statBar.render(g);
        	statBar.tick();
        }
        bs.show();
        g.dispose();
    }
    
    //GAMELOOP - updates all variables, positions of objects and renders them to the screen
    public void run(){
        init(); 
        int fps = 60; //how many times per second the tick and render methods run
        double timePerTick = 1000000000 / fps; //1 bil. nanoseconds in one second. 1 sec divided by fps gets max time allowed to run tick and render methods to achieve 60fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //returns current pc time as nanoseconds
        long timer = 0; 
        int ticks = 0;
        
        while(running){
        	now = System.nanoTime(); 
        	delta += (now - lastTime) / timePerTick;  //how much time till tick and render are called again
        	timer += now - lastTime;
        	lastTime = now;
        	if(delta >= 1){
	        	tick();
	            render();
	            ticks++;
	            delta--;
        	}
           if(timer >= 1000000000){
        	   //show fps
        	   //System.out.println("Ticks and Frames: " + ticks);
        	   ticks = 0;
        	   timer = 0;
           }
        }
        stop();
    }
    
    public KeyManager getKeyManager(){	//return KeyManager object so other classes can access it
    	return keyManager;
    }
    
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join(); 
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
