package Common;

public class Collision extends HitBoxes {

    //HitBoxes hitBoxes1 = new HitBoxes(boxX,boxY,Width,Height);

    public boolean collied(int x1 ,int y1 ,int width1,int height1, int x2, int y2, int width2, int height2)
    {
        CollisionCheck( x1 , y1 , width1, height1,  x2, y2, width2,height2);
        return collided;
    }
}