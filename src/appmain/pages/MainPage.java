package appmain.pages;

import appmain.app_define.PageEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends PageBase {
    private JButton newGameButton;
    private JButton createChallengeButton;
    private JButton highScoreButton;
    private JButton controlButton;
    private JButton helpButton;
    private JPanel container;

    public MainPage() {
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (client != null){
                    client.onPageEvent(PageEvent.START_NEW_GAME);
                }
            }
        });
        createChallengeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        highScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        controlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public Container getContainer() {
        return container;
    }
}
