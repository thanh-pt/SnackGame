package appmain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class ViewMain {
    private JFrame          frmMain;

    private Snack           snack;

    class Keyhandler implements KeyListener {
        SnakeHeader snakeHeader;

        public Keyhandler(SnakeHeader snakeHeaderObj){
            snakeHeader = snakeHeaderObj;
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e);
            if (e.getKeyCode() == KeyEvent.VK_U){
                snakeHeader.setDirection(SnakeHeader.Direction.UP);
                System.out.println("vao1");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class DrawingPanel extends JPanel {
        private void doDrawing(Graphics g) {

            var g2d = (Graphics2D) g;

            g2d.setColor(Color.blue);

            Vector<Point> body = snack.getBody();
            for (int i = 0; i < body.size(); ++i){
                g2d.fillRect(body.get(i).getX(), body.get(i).getY(), 10, 10);
            }
            g2d.fillRect(snack.getHeader().getX(), snack.getHeader().getY(), 12,12);

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
        }
    }

    public ViewMain(){
        snack = new Snack();

        frmMain = new JFrame();
        frmMain.setTitle("Snack game");

        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setBounds(0, 0, 320, 320);

        frmMain.add(drawingPanel);

        frmMain.setSize(320,400);
        frmMain.setLayout(null);
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Keyhandler keyhandler = new Keyhandler(snack.getHeader());

        frmMain.addKeyListener(keyhandler);
        frmMain.setFocusable(true);


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snack.update();
                drawingPanel.updateUI();
            }
        });
        timer.start();
    }
}
