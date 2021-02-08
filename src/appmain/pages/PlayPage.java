package appmain.pages;

import appmain.app_define.PageEvent;
import appmain.engine.SnakeGame;
import appmain.service.IKeyServiceListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPage extends PageBase {
    private JTextField textField1;
    private JTextField textField2;
    private JButton exitButton;
    private JPanel container;
    private JPanel pnlPlay;

    private SnakeGame snakeGame = null;

    public PlayPage() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.onPageEvent(PageEvent.BACK_TO_MAIN);
            }
        });
    }

    @Override
    public Container getContainer() {
        return container;
    }

    public void startSnakeGame(){
        if (snakeGame == null){
            snakeGame = new SnakeGame();
            pnlPlay.add(snakeGame);
            snakeGame.initGame();
        }
    }

    public IKeyServiceListener getKeyServiceListener(){
        return snakeGame;
    }
}
