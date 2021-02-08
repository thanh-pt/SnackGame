package appmain;

import appmain.app_define.PageEvent;
import appmain.engine.SnakeGame;
import appmain.pages.*;
import appmain.service.KeyService;

import javax.swing.*;

public class AppMain implements IPageListener {
    private JFrame frmMain;
    // Pages
    private MainPage mainPage;
    private PlayPage playPage;
    private SnakeGame playGameSnakePage;
    // Service
    private KeyService keyService;

    public AppMain(){
        frmMain = new JFrame();
        frmMain.setTitle("Snack game");
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        keyService = new KeyService();
        frmMain.addKeyListener(keyService);

        mainPage = new MainPage();
        playPage = new PlayPage();

        frmMain.getContentPane().add(playPage.getContainer());
        frmMain.getContentPane().add(mainPage.getContainer());
        setPage(mainPage);
    }

    public void setPage(PageBase page){
        frmMain.setContentPane(page.getContainer());
        page.setClient(this);
        frmMain.pack();
    }

    public static void main(String[] args) {
        new AppMain();
    }

    @Override
    public void onPageEvent(PageEvent event) {
        switch (event){
            case START_NEW_GAME:
                setPage(playPage);
                playPage.startSnakeGame();
                keyService.setClient(playPage.getKeyServiceListener());
                frmMain.requestFocus();
                break;
            case BACK_TO_MAIN:
                setPage(mainPage);
                keyService.setClient(null);
                break;
        }
    }
}
