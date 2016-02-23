package mazegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import mazegame.Handler;

public class PausedState extends State{

	public PausedState(Handler handler) {
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
		Font bigFont = new Font("Lucida Sans Demibold", Font.BOLD, 40);
		Font mainFont = new Font("Lucida Sans Demibold", Font.BOLD, 30);
		
		drawText(g, "PAUSED", 220, bigFont);
		drawText(g, "Press SPACE_BAR to resume", 380, mainFont);		
	}
	
	public void drawText(Graphics g, String text, int height, Font font) {	
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = (handler.getWidth() - metrics.stringWidth(text)) / 2;	    // Determine the X coordinate for the text
	    g.setFont(font);
	    g.drawString(text, x, height);
	}

	
}
