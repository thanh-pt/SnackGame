package appmain.object;

import appmain.Utility;
import appmain.app_define.Direction;

public class SnakeHeader extends Point {

    private Direction direction = Direction.NON;
    private int minX = 0;
    private int minY = 0;
    private int maxX = 0;
    private int maxY = 0;

    public void update(){
        switch (getDirection()){
            case UP:
                --y;
                break;
            case DOWN:
                ++y;
                break;
            case LEFT:
                --x;
                break;
            case RIGHT:
                ++x;
                break;
        }
        x = Utility.verifyPos(x, minX, maxX);
        y = Utility.verifyPos(y, minY, maxY);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setMaxPos(int newMaxX, int newMaxY){
        maxX = newMaxX;
        maxY = newMaxY;
    }
}
