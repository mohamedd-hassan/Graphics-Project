import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {
    int pox,poy; // position x,y
    int radius;
    int startingAngle;
    int addingAngle;



    Player(int posX, int posY,int _radius,int _startingAngle,int _addingAngle)
    {
        pox=posX;
        poy=posY;
        radius=_radius;
        startingAngle=_startingAngle;
        addingAngle=_addingAngle;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillArc(pox,poy,radius,radius,startingAngle,addingAngle);
    }

}
