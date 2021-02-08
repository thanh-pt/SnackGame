package appmain.engine;

import appmain.Utility;
import appmain.app_define.Direction;
import appmain.app_define.PageEvent;
import appmain.object.Fruit;
import appmain.object.Point;
import appmain.object.Snack;
import appmain.object.Wall;
import appmain.service.IKeyServiceListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class SnakeGame extends JPanel implements IKeyServiceListener {
    private Snack   snack;
    private Fruit   fruit;
    private Wall    wall;
    private Timer   timer = null;
    private int     pixelSize = 10;

    public SnakeGame(){
        // Timer setup
        timer = new Timer(200, e -> {
            snack.update();
            if (snack.getHeader().compare(fruit)){
                snack.growUp();
                fruit.reset();
            }
            if (wall.isContain(snack.getHeader())){
                timer.stop();
            } else {
                updateUI();
            }
        });
    }

    public void initGame(){
        // Snack initialize
        snack = new Snack();
        snack.getHeader().setPosition(10, 10);
        snack.getHeader().setMaxPos(getParent().getWidth()/pixelSize, getParent().getHeight()/pixelSize);

        fruit = new Fruit();
        fruit.setMaxPos(getParent().getWidth()/pixelSize, getParent().getHeight()/pixelSize);
        fruit.reset();

        wall = new Wall();
    }

    private void drawPoint(Graphics2D g2d, Point p){
        g2d.fillRect(p.getX() * pixelSize, p.getY() * pixelSize, pixelSize, pixelSize);
    }

    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g;
        setBackground(Color.GRAY);

        g2d.setColor(Color.PINK);

        if (snack != null){
            Vector<appmain.object.Point> body = snack.getBody();
            for (Point point : body) {
                drawPoint(g2d, point);
            }
            g2d.setColor(Color.red);
            drawPoint(g2d, snack.getHeader());
        }
        if (fruit != null){
            g2d.setColor(Color.GREEN);
            drawPoint(g2d, fruit);
        }
        if (wall != null){
            g2d.setColor(Color.DARK_GRAY);
            for (Point point : wall.getData()){
                drawPoint(g2d, point);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void ActionHandle(int keyCode) {
        Direction dir = Utility.KeyCode2Directory(keyCode);
        if (dir != Direction.NON){
            snack.getHeader().setDirection(dir);
        }
        if (keyCode == KeyEvent.VK_SPACE){
            if (timer.isRunning()){
                timer.stop();
            } else {
                timer.start();
            }
        }
    }
}
