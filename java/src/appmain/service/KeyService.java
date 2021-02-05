package appmain.service;

import appmain.ViewMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyService implements KeyListener {
    ViewMain view;
    public KeyService(ViewMain newView){
        view = newView;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        view.ActionHandle(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
