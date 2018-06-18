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
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene=HSceneFactory.getInstance().getDefaultHScene();
        
        gui = new Container(){
            public void paint(Graphics graphics){
                
                graphics.setColor(Color.BLACK);
                
                graphics.fillRect(0, 0, sceneWidth, sceneHeight);

                player1.paint(graphics);
                player2.paint(graphics);
            }
        };
        
        scene.add(gui, BorderLayout.CENTER);
        scene.validate();
        
        gui.setSize(sceneWidth, sceneHeight);
        
     
        player1 = new Player(50, sceneHeight/2);
        player2 = new Player(sceneWidth - 50, sceneHeight/2);
        
        // SCHERM = 720 x 576
        
        //HStaticText hst0=new HStaticText("Dit is een basis scene",0,100,720,376); // tekst,x,y,w,h
        //HStaticText hst1=new HStaticText("Dit is een basis scene",0,476,720,100); // tekst,x,y,w,h
        //HStaticText hst2=new HStaticText("Dit is een basis scene",0,0,720,100); // tekst,x,y,w,
               
        //hst0.setBackgroundMode(HVisible.BACKGROUND_FILL);
        //hst0.setBackground(Color.GREEN);
        
        //hst1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        //hst1.setBackground(Color.BLACK);
        
        //hst2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        //hst2.setBackground(Color.BLACK);
        
        //scene.add(hst0);
        //scene.add(hst1);
        //scene.add(hst2);
        
        //scene.validate();
        //scene.setVisible(true);
             
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
        gui.setVisible(true);
        scene.setVisible(true); 
    }
    
    


  
}