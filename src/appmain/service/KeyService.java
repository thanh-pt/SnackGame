package appmain.service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyService implements KeyListener {
    IKeyServiceListener client = null;
    public KeyService(){
    }

    public void setClient(IKeyServiceListener clientObj){
        client = clientObj;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (client != null){
            client.ActionHandle(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
