/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
//import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author student
 */
public class PongBall {
    //private Point pos;
    private int posX;
    private int posY;
    private int speedY = 0;
    private int speedGeneral = 10;
    private int normalDirection = 1;
    private int turnDirectionAround = -1;
    private int state = 0;    
    private int width = 30;
       
    public PongBall(int basePosX, int basePosY)
    {
        posX = basePosX;
        posY = basePosY;
    }
    
    public void paint (Graphics graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(posX - width/2, posY - width/2, width, width);
    }
    
    //public void setPosition(int y){pos.y = y;}
    
    private boolean hitboxCollision(Player player){
        Rectangle playerHitBox = player.getHitbox();
        Rectangle ballHitbox = new Rectangle((posX - (width/2)), (posY - (width/2)), width, width);
        if(ballHitbox.intersects(playerHitBox)){ return true;}
        else return false;
    }
    
    public void update (boolean isSpacePressed)
    {
       if(state == 0){state = 1;}
       
       if(state == 1){
           posY += speedY;
           
           posX += speedGeneral * normalDirection;

           if(hitboxCollision(HelloTVXlet.player1) || hitboxCollision(HelloTVXlet.player2)){
               normalDirection *= turnDirectionAround;
               if(speedY == 0)speedY = 5;
           }
       }
       reflectOffWall();
    }
    
   private void reflectOffWall(){
        if(posY - width/2 <= 0 || posY + width/2 >= HelloTVXlet.sceneHeight){ speedY *= turnDirectionAround;}
    }
        
}
