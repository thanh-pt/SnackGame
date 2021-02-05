package appmain;

import java.util.Vector;

public class Snack {
    private SnakeHeader header;
    private Vector<Point> body;
    private int moveSize = 10;

    public Snack(){
        header = new SnakeHeader();
        header.setDirection(SnakeHeader.Direction.RIGHT);
        body = new Vector<>();
        body.add(new Point(-10,0));
    }

    public void update(){
        for (int i = body.size()-1; i > 0; --i){
            body.get(i).setX(body.get(i-1).getX());
            body.get(i).setY(body.get(i=1).getY());
        }
        if (body.size() > 0){
            body.get(0).setX(header.getX());
            body.get(0).setY(header.getY());
        }
        switch (header.getDirection()){
            case UP -> {
                header.setY(header.getY()+moveSize);
                break;
            }
            case DOWN -> {
                header.setY(header.getY()-moveSize);
                break;
            }
            case LEFT -> {
                header.setX(header.getX()-moveSize);
                break;
            }
            case RIGHT -> {
                header.setX(header.getX()+moveSize);
                break;
            }
        }
    }

    public SnakeHeader getHeader() {
        return header;
    }

    public Vector<Point> getBody() {
        return body;
    }
}
