package appmain.object;

public class Point {
    protected int x;
    protected int y;

    public Point(){
        x = 0;
        y = 0;
    }

    public Point(int newX, int newY){
        x = newX;
        y = newY;
    }

    public void Copy(Point point){
        x = point.getX();
        y = point.getY();
    }

    public void setPosition(int newX, int newY){
        x = newX;
        y = newY;
    }

    public boolean compare(Point point){
        if (x == point.x && y == point.y){
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
