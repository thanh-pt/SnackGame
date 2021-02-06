package appmain.object;

import java.util.Vector;

public class Wall {
    private Vector<Point> data;

    public Wall(){
        data = new Vector<>();
        for (int i = 0; i < 10; ++i){
            data.add(new Point(20, i+5));
        }
    }

    public Vector<Point> getData() {
        return data;
    }

    public boolean isContain(Point point){
        for (Point p : data){
            if (p.compare(point) == true){
                return true;
            }
        }
        return false;
    }
}
