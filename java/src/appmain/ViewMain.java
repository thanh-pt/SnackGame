package appmain;

import appmain.enum_def.Direction;
import appmain.object.Fruit;
import appmain.object.Snack;
import appmain.object.Wall;
import appmain.service.DrawingPanel;
import appmain.service.KeyService;

import javax.swing.*;

public class ViewMain {

    private Snack snack;
    private Fruit fruit;
    private Timer timer;

    public ViewMain(){
        // Init GUI component
        JFrame          frmMain         = new JFrame();
        DrawingPanel    drawingPanel    = new DrawingPanel();
        KeyService      keyService      = new KeyService(this);

        // Set component property
        drawingPanel.setBounds(0, 0, 320, 320);

        // Add component to main Frame
        frmMain.add(drawingPanel);

        // Setup main Frame
        frmMain.setTitle("Snack game");
        frmMain.setSize(400,400);
        frmMain.setLayout(null);
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmMain.addKeyListener(keyService);
        frmMain.setFocusable(true);

        // Snack initialize
        snack = new Snack();
        snack.getHeader().setPosition(10, 10);
        snack.getHeader().setMaxPos(drawingPanel.getMaxPixel(), drawingPanel.getMaxPixel());

        fruit = new Fruit();
        fruit.setMaxPos(drawingPanel.getMaxPixel(), drawingPanel.getMaxPixel());
        fruit.reset();

        Wall wall = new Wall();

        drawingPanel.setSnack(snack);
        drawingPanel.setFruit(fruit);
        drawingPanel.setWall(wall);

        // Timer setup
        timer = new Timer(200, e -> {
            snack.update();
            if (snack.getHeader().compare(fruit) == true){
                snack.growUp();
                fruit.reset();
            }
            if (wall.isContain(snack.getHeader()) == true){
                timer.stop();
            } else {
                drawingPanel.updateUI();
            }
        });
        timer.start();
    }

    public void ActionHandle(int keyCode){
        Direction dir = Utility.KeyCode2Directory(keyCode);
        if (dir != Direction.NON){
            snack.getHeader().setDirection(dir);
        }
    }

    public static void main(String[] args) {
        ViewMain appMain = new ViewMain();
    }
}
