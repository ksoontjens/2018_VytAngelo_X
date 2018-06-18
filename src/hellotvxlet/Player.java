package hellotvxlet;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author student
 */
public class Player {

    private Point pos;
    
    public Player(int xPos, int yPos){
        pos = new Point(xPos, yPos);
    }
    
    public void paint(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(pos.x - 25/2, pos.y - 80/2, 25, 80);
    }
        
    public void setPosition(int yPos){
        pos.y = yPos;
    }
    
}
