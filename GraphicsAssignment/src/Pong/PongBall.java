package Pong;

import Common.HitBoxes;

import javax.swing.*;
import java.awt.*;

public class PongBall extends JPanel {
    int x , y, diameter;
    HitBoxes boxes=new HitBoxes(x,y,diameter,diameter);
    PongBall(int ballx,int bally,int ballDiamter,HitBoxes box)
    {
        x=ballx;
        y=bally;
        diameter=ballDiamter;
        boxes=box;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.white);
        g.fillOval(x,y,diameter,diameter);
    }
}
