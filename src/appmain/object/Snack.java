package appmain.object;

import appmain.enum_def.Direction;

import java.util.Vector;

public class Snack {
    private SnakeHeader header;
    private Vector<Point> body;

    public Snack(){
        header = new SnakeHeader();
        header.setDirection(Direction.RIGHT);
        body = new Vector<>();
        body.add(new Point(-1,-1));
        body.add(new Point(-1,-1));
        body.add(new Point(-1,-1));
    }

    public void update(){
        for (int i = body.size()-1; i > 0; --i){
            body.get(i).Copy(body.get(i-1));
        }
        if (body.size() > 0){
            body.get(0).Copy(header);
        }
        header.update();
    }

    public SnakeHeader getHeader() {
        return header;
    }

    public Vector<Point> getBody() {
        return body;
    }

    public void growUp(){
        body.add(new Point(-1, -1));
    }
}
