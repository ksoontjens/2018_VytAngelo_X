/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;



import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;

/**
 *
 * @author student
 */
public class KeyInputs {
    
    static public boolean up_player1;
    static public boolean down_player1;
    static public boolean up_player2;
    static public boolean down_player2;
    
    public KeyInputs(){
        
        //Repository
        UserEventRepository repository = new UserEventRepository("Movement");
              
        //events toevoegen
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_W);
        repository.addKey(HRcEvent.VK_Z);
        repository.addKey(HRcEvent.VK_S);
        
        //Listener
        UserEventListener listener = new UserEventListener() {
            //Opvangen van de Key events
            public void userEventReceived(UserEvent e) 
            {
                if(e.getType() == HRcEvent.KEY_PRESSED){applyKeyInput(e, true);}
                else if (e.getType() == HRcEvent.KEY_RELEASED){applyKeyInput(e, false);}
            }
        };
        
        //Bekend maken bii eventmanager
        EventManager.getInstance().addUserEventListener(listener, repository);   
    }
    
    private void applyKeyInput(UserEvent e, boolean isPressed){
        switch(e.getCode()){
            case HRcEvent.VK_Z: up_player1 = isPressed; System.out.println("VK_Z is pressed"); break;
            case HRcEvent.VK_S: down_player1 = isPressed; System.out.println("VK_S is pressed"); break;
            case HRcEvent.VK_UP: up_player2 = isPressed; System.out.println("VK_UP is pressed"); break;
            case HRcEvent.VK_DOWN: down_player2 = isPressed; System.out.println("VK_DOWN is pressed"); break;
        }
    }
}
