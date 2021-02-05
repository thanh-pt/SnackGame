package appmain;

import appmain.service.KeyService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ViewMain {

    private Snack snack;

    class DrawingPanel extends JPanel {
        private void doDrawing(Graphics g) {

            var g2d = (Graphics2D) g;

            g2d.setColor(Color.blue);

            Vector<Point> body = snack.getBody();
            for (Point point : body) {
//                g2d.fillRect(point.getX() * 10, point.getY() * 10, 10, 10);
                g2d.drawRect(point.getX() * 10, point.getY() * 10, 10, 10);
            }
            g2d.setColor(Color.red);
//            g2d.fillRect(snack.getHeader().getX()*10, snack.getHeader().getY()*10, 10,10);
            g2d.drawRect(snack.getHeader().getX()*10, snack.getHeader().getY()*10, 10,10);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
        }
    }

    public ViewMain(){
        snack = new Snack();

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
        frmMain.setSize(320,400);
        frmMain.setLayout(null);
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmMain.addKeyListener(keyService);
        frmMain.setFocusable(true);


        Timer timer = new Timer(200, e -> {
            snack.update();
            drawingPanel.updateUI();
        });
        timer.start();
    }

    public void ActionHandle(int keyCode){
        SnakeHeader.Direction dir = Utility.KeyCode2Directory(keyCode);
        if (dir != SnakeHeader.Direction.NON){
            snack.getHeader().setDirection(dir);
        }
    }
}
