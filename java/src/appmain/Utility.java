package appmain;

import java.awt.event.KeyEvent;

public class Utility {
    static SnakeHeader.Direction KeyCode2Directory(int keyCode){
        SnakeHeader.Direction dirResult = SnakeHeader.Direction.NON;
        switch (keyCode){
            case KeyEvent.VK_UP:
                dirResult = SnakeHeader.Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                dirResult = SnakeHeader.Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                dirResult = SnakeHeader.Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                dirResult = SnakeHeader.Direction.RIGHT;
                break;
        }
        return dirResult;
    }
}
