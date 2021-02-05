package appmain;

public class Point {
    private int x;
    private int y;

    public Point(){
        x = 0;
        y = 0;
    }
    public Point(int newX, int newY){
        x = newX;
        y = newY;
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
