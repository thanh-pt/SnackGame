package appmain;

import appmain.app_define.PageEvent;
import appmain.pages.IPageListener;
import appmain.pages.MainPage;
import appmain.pages.PlayGameSnakePage;
import appmain.service.KeyService;

import javax.swing.*;
import java.awt.*;

public class AppMain implements IPageListener {
    private JFrame frmMain;
    // Pages
    private MainPage mainPage;
    private PlayGameSnakePage playGameSnakePage;
    // Service
    private KeyService keyService;

    public AppMain(){
        frmMain = new JFrame();
        frmMain.setTitle("Snack game");
        frmMain.setVisible(true);
        frmMain.pack();
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        keyService = new KeyService();
        frmMain.addKeyListener(keyService);

        mainPage = new MainPage();
        mainPage.setClient(this);

        playGameSnakePage = new PlayGameSnakePage();
        playGameSnakePage.setClient(this);

        frmMain.getContentPane().add(mainPage.getPnlContent());
        frmMain.setSize(400, 450);
    }

    public void setPage(Container container){
        frmMain.setContentPane(container);
    }

    public static void main(String[] args) {
        new AppMain();
    }

    @Override
    public void onPageEvent(PageEvent event) {
        switch (event){
            case START_NEW_GAME:
                setPage(playGameSnakePage);
                keyService.setClient(playGameSnakePage);
                frmMain.setSize(400,450);
                frmMain.requestFocus();
                break;
            case EXIT_SNAKE_GAME:
                setPage(mainPage.getPnlContent());
                keyService.setClient(null);
                break;
        }
    }
}
