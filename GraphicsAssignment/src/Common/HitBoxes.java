package Common;

import javax.swing.*;

public class HitBoxes extends JPanel {
    int boxX,boxY,Width,Height;
    public boolean collided;
    public HitBoxes(){}

    public HitBoxes(int x, int y, int boxWidth, int boxHeight)
    {
        boxX=x;
        boxY=y;
        Width=boxWidth;
        Height=boxHeight;
    }
    public void CollisionCheck(int x1 ,int y1 ,int width1,int height1, int x2, int y2, int width2, int height2)
    {
     if (x2<=x1&& x1 <= x2+width2 && y2 <= y1&& y1 <= y2+height2 || x2<=x1+width1&& x1+width1 <= x2+width2 && y2 <= y1+height1&& y1+height1 <= y2+height2|| x2<=x1+width1&& x1+width1 <= x2+width2 && y2 <= y1&& y1 <= y2+height2|| x2<=x1&& x1 <= x2+width2 && y2 <= y1+height1&& y1+height1 <= y2+height2)
        {
            collided=true;
        }
     if (x2 >= x1 && x1 >= x2+width2 && y2 >= y1 && y1 >= y2+height2|| x2>=x1+width1&& x1+width1 >= x2+width2 && y2 >= y1+height1&& y1+height1 >= y2+height2|| x2>=x1+width1&& x1+width1 >= x2+width2 && y2 >= y1&& y1 >= y2+height2|| x2>=x1&& x1 >= x2+width2 && y2 >= y1+height1&& y1+height1 >= y2+height2)
        {
            collided=false;
        }
    }
}
