public class Collision extends HitBoxes {

    public boolean collied(HitBoxes hitBoxes1, HitBoxes hitBoxes2)
    {
        CollisionCheck(hitBoxes1.boxX,hitBoxes1.boxY,hitBoxes1.Width,hitBoxes1.Height,hitBoxes2.boxX,hitBoxes2.boxY,hitBoxes2.Width,hitBoxes2.Height);
       return collided;
    }
}