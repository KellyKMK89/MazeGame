
package mazegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/* This class sets up the Display and adds a canvas to the JFrame*/

public class Display {
    
    private JFrame frame;   //display the canvas in the JFrame
    private Canvas canvas;  //graphics get drawn onto the canvas
    
    private String title;
    private int width;
    private int height;


    
    //CONSTRUCTOR
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }
    
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);  //window will appear middle of screen
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));    //make sure canvas can't change size
        canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);		//JFrame is only thing that has focus
        
        frame.add(canvas);
        frame.pack();   //fits all of canvas to frame
    }
    
    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame(){
    	return frame;	//need to access this JFrame outside of the display class
    }
}
