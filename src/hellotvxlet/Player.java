package hellotvxlet;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author student
 */
public class Player {

    private Point pos;
    private int width = 25;
    private int height = 125;
    
    public Player(int x, int y){ pos = new Point(x, y); }
    
    public void paint(Graphics graphics, Color color){
        graphics.setColor(color);
        graphics.fillRect(pos.x - width/2, pos.y - height/2, width, height);
    }
        
    public void setPosition(int y){pos.y = y;}
    
    public void update(boolean up, boolean down){
        if(up){ pos.y -= 20;}
        else if(down){pos.y += 20;}
        
        if(pos.y < (height/2) ) pos.y = height/2; // top of the screen
        if(pos.y > (HelloTVXlet.sceneHeight - height/2) ) pos.y = HelloTVXlet.sceneHeight- height/2; // bottom of the screen
    }
    
    public Rectangle getHitbox(){
        return new Rectangle(pos.x - width/2, pos.y - height/2, width, height);
    }
}
