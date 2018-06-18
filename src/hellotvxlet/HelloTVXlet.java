package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet {

    public Player player1;
    public Player player2;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        // SCHERM = 720 x 576
        
        HStaticText hst0=new HStaticText("Dit is een basis scene",0,100,720,376); // tekst,x,y,w,h
        HStaticText hst1=new HStaticText("Dit is een basis scene",0,476,720,100); // tekst,x,y,w,h
        HStaticText hst2=new HStaticText("Dit is een basis scene",0,0,720,100); // tekst,x,y,w,
               
        hst0.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hst0.setBackground(Color.GREEN);
        
        hst1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hst1.setBackground(Color.BLACK);
        
        hst2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hst2.setBackground(Color.BLACK);
        
        scene.add(hst0);
        scene.add(hst1);
        scene.add(hst2);
        
        scene.validate();
        scene.setVisible(true);
        
        player1 = new Player(50, 576/2);
        player2 = new Player(720 - 50, 576/2);
        
        player1.setPosition(576/2);
        player2.setPosition(576/2); 
      
    }

    public void pauseXlet() {
       
    }

    public void startXlet() throws XletStateChangeException {
     
    }


  
}