package appmain.service;

import appmain.ViewMain;
import appmain.object.Fruit;
import appmain.object.Point;
import appmain.object.Snack;
import appmain.object.Wall;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class DrawingPanel extends JPanel {
    private Snack   snack = null;
    private Fruit   fruit = null;
    private Wall    wall  = null;
    private int     pixelSize = 10;

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

    public int getMaxPixel() {
        return getWidth() / pixelSize-1;
    }

    public void setSnack(Snack snackObj){
        this.snack = snackObj;
    }

    public void setFruit(Fruit fruitObj){
        this.fruit = fruitObj;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }
}
