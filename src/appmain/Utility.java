package appmain;

import appmain.enum_def.Direction;

import java.awt.event.KeyEvent;

public class Utility {
    static Direction KeyCode2Directory(int keyCode){
        Direction dirResult = Direction.NON;
        switch (keyCode){
            case KeyEvent.VK_UP:
                dirResult = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                dirResult = Direction.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                dirResult = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                dirResult = Direction.RIGHT;
                break;
        }
        return dirResult;
    }

    static public int verifyPos(int pos, int min, int max){
        if (pos > max){
            return min;
        }
        if (pos < min){
            return max;
        }
        return pos;
    }
}
