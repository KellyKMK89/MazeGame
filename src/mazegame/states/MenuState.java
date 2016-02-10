package mazegame.states;

import java.awt.*;
import mazegame.Handler;

public class MenuState extends State {
	
	public MenuState(Handler handler){
		super(handler);
	}

	/*Draw a string in the centre of the game screen*/
	public void drawText(Graphics g, String text, int height, Font font) {	
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = (handler.getWidth() - metrics.stringWidth(text)) / 2;	    // Determine the X coordinate for the text
	    g.setFont(font);
	    g.drawString(text, x, height);
	}
	
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		Color darkRed = new Color(120,10,10);
		Color olive = new Color(200,220,140);
		g.setColor(olive);
		g.fillRect(0, 0, 800, 600);
		g.setColor(darkRed);
		Font titleFont = new Font("Mistral",Font.BOLD, 70);
		Font mainFont = new Font("Lucida Sans Demibold", Font.ITALIC, 25);
		Font bigFont = new Font("Lucida Sans Demibold", Font.BOLD, 35);
		Font plainFont  = new Font("Lucida Sans Demibold", Font.BOLD, 30);
		
		drawText(g, "MAZE MONSTER", 100, titleFont);
		drawText(g, "The monsters have stolen your bones!", 200, mainFont);
		drawText(g, "Get your bones back", 240, mainFont);
		drawText(g, "Make it to the end of the maze", 280, mainFont);
		drawText(g, "Watch out for monsters!", 320, mainFont);
		drawText(g, "Use W, A, S, D keys to move", 420, plainFont);	
		drawText(g, "PRESS SPACEBAR TO START", 530, bigFont);	
		
	}

}
