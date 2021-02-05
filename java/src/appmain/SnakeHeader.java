package appmain;

public class SnakeHeader extends Point {
    public enum Direction {
        NON,
        RIGHT,
        LEFT,
        UP,
        DOWN
    };

    private Direction direction = Direction.NON;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
