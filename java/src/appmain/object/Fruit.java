package appmain.object;

import java.util.Random;

public class Fruit extends Point{
    private Random rand = new Random();
    private int maxX = 1;
    private int maxY = 1;

    public void reset(){
        x = rand.nextInt(maxX);
        y = rand.nextInt(maxY);
    }

    public void setMaxPos(int newMaxX, int newMaxY){
        maxX = newMaxX;
        maxY = newMaxY;
    }
}
