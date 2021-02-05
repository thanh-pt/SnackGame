package appmain;

import java.util.Vector;

public class Snack {
    private SnakeHeader header;
    private Vector<Point> body;

    public Snack(){
        header = new SnakeHeader();
        header.setDirection(SnakeHeader.Direction.RIGHT);
        body = new Vector<>();
        body.add(new Point(-1,0));
        body.add(new Point(-2,0));
        body.add(new Point(-3,0));
    }

    public void update(){
        for (int i = body.size()-1; i > 0; --i){
            body.get(i).Copy(body.get(i-1));
        }
        if (body.size() > 0){
            body.get(0).Copy(header);
        }
        switch (header.getDirection()){
            case UP:
                header.setY(header.getY()-1);
                break;
            case DOWN:
                header.setY(header.getY()+1);
                break;
            case LEFT:
                header.setX(header.getX()-1);
                break;
            case RIGHT:
                header.setX(header.getX()+1);
                break;
        }
    }

    public SnakeHeader getHeader() {
        return header;
    }

    public Vector<Point> getBody() {
        return body;
    }
}
