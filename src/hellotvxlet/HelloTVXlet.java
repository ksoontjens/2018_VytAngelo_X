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
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet {

    private int sceneWidth = 720;
            
    private int sceneHeight = 576;
    
    public Player player1;
    public Player player2;
    
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

                player1.paint(graphics);
                player2.paint(graphics);
            }
        };
        
        scene.add(gui, BorderLayout.CENTER);
        scene.validate();
        
        gui.setSize(sceneWidth, sceneHeight);
       
        player1 = new Player(40, sceneHeight/2);
        player2 = new Player(sceneWidth - 40, sceneHeight/2);
        
        keyInputs = new KeyInputs();
                  
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
        gui.setVisible(true);
        scene.setVisible(true); 
        
        while(true){
            long currentTime = System.currentTimeMillis();
                       
            //draws frame after update
            scene.paint(scene.getGraphics());
            scene.validate();
            
            player1.update(KeyInputs.up_player1, KeyInputs.down_player1);
            player2.update(KeyInputs.up_player2, KeyInputs.down_player2);
            
            try { Thread.sleep(1000 / 30 - (System.currentTimeMillis() - currentTime)); }
            catch (InterruptedException exception) { exception.printStackTrace(); }
        }
    }
    
    


  
}