package mazegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import mazegame.Handler;

public class GameOverState extends State{

	public GameOverState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Color darkRed = new Color(120,10,10);
		Color olive = new Color(200,220,140);
		g.setColor(olive);
		g.fillRect(0, 0, 800, 600);
		g.setColor(darkRed);
		Font bigFont = new Font("Lucida Sans Demibold", Font.BOLD, 40);
		Font mainFont = new Font("Lucida Sans Demibold", Font.BOLD, 30);
		
		drawText(g, "GAME OVER", 220, bigFont);
		drawText(g, "Press SPACE_BAR to play again", 380, mainFont);		
	}
	
	public void drawText(Graphics g, String text, int height, Font font) {	
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = (handler.getWidth() - metrics.stringWidth(text)) / 2;	    // Determine the X coordinate for the text
	    g.setFont(font);
	    g.drawString(text, x, height);
	}

	
}
