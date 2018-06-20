package hellotvxlet;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.BorderLayout;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import java.awt.Font;

public class HelloTVXlet implements Xlet {

    static public int sceneWidth = 720;
            
    static public int sceneHeight = 576;
    
    static public Player player1;
    static public Player player2;
    
    static public int player1Points = 0;
    static public int player2Points = 0;
    private String score;
    
    public PongBall pongBall;
    
    private HScene scene;
    
    private Container gui;
    
    private KeyInputs keyInputs;
       
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene=HSceneFactory.getInstance().getDefaultHScene();
        
        gui = new Container(){
            public void paint(Graphics graphics){
                
                graphics.setColor(Color.DARK_GRAY);
                graphics.fillRect(0, 0, sceneWidth, sceneHeight);
                
                graphics.setColor(Color.WHITE);
                graphics.fillRect(sceneWidth/2, 0, 3, sceneHeight);
                //graphics.fillRect(sceneWidth/4, 0, 3, sceneHeight);
                //graphics.fillRect(3*sceneWidth/4, 0, 3, sceneHeight);

                player1.paint(graphics, Color.CYAN);
                player2.paint(graphics, Color.RED);
                pongBall.paint(graphics);
                
                graphics.setFont(new Font("TimesRoman", Font.BOLD, 40));
                graphics.setColor(Color.WHITE);
                score = "                 " + player1Points;
                score +="                 ";               
                score +="                 " + player2Points;
                graphics.drawString(score, 0, 40);
            }
        };
        
        scene.add(gui, BorderLayout.CENTER);
        scene.validate();
        
        gui.setSize(sceneWidth, sceneHeight);
       
        player1 = new Player(20, sceneHeight/2);
        player2 = new Player(sceneWidth - 20, sceneHeight/2);
        
        pongBall = new PongBall(sceneWidth/2, sceneHeight/2);
        
        keyInputs = new KeyInputs();
                  
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
        gui.setVisible(true);
        scene.setVisible(true); 
        
        while(true){
            long currentTime = System.currentTimeMillis();
                       
            scene.paint(scene.getGraphics());
            scene.validate();
            
            player1.update(keyInputs.up_player1, keyInputs.down_player1);
            player2.update(keyInputs.up_player2, keyInputs.down_player2);
            
            pongBall.update(true);
            
            //if ((pongBall.posX) > sceneWidth) player1Points ++;
            
            try { Thread.sleep(1000 / 30 - (System.currentTimeMillis() - currentTime)); }
            catch (InterruptedException exception) { exception.printStackTrace(); }
        }
    }
    
    


  
}