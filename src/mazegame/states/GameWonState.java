package mazegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import mazegame.Handler;

public class GameWonState extends State{
	
	public GameWonState(Handler handler){
		super(handler);
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
		
		drawText(g, "YOU WIN!", 100, titleFont);
		drawText(g, "Thank you for playing MAZE MONSTER", 240, mainFont);
		drawText(g, "Game design and coding by Kelly Krook", 320, mainFont);
		drawText(g, "PRESS SPACEBAR TO PLAY AGAIN", 530, bigFont);	
		
	}
	
	public void drawText(Graphics g, String text, int height, Font font) {	
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = (handler.getWidth() - metrics.stringWidth(text)) / 2;	    // Determine the X coordinate for the text
	    g.setFont(font);
	    g.drawString(text, x, height);
	}
}
