package Pacman;

import Common.HitBoxes;

import javax.swing.*;
import java.awt.*;

public class PacPlayer extends JPanel  {
    int pox,poy; // position x,y
    int radius;
    int startingAngle;
    int addingAngle;

    HitBoxes hitBoxes;

    PacPlayer(int posX, int posY, int _radius, int _startingAngle, int _addingAngle, HitBoxes boxes)
    {
        pox=posX;
        poy=posY;
        radius=_radius;
        startingAngle=_startingAngle;
        addingAngle=_addingAngle;
        hitBoxes=boxes;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillArc(pox,poy,radius,radius,startingAngle,addingAngle);
    }

}
