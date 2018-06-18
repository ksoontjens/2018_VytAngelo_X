package hellotvxlet;

import java.awt.Point;

/**
 *
 * @author student
 */
public class Player {

    private Point pos;
    
    public Player(int xPos, int yPos){
        pos = new Point(xPos, yPos);
    }
        
    public void setPosition(int yPos){
        pos.y = yPos;
    }
    
}
