import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {
    int pox,poy; // position x,y
    int radius;
    int startingAngle;
    int addingAngle;

    Player(int pox, int poy,int radius,int startingAngle,int addingAngle)
    {
        pox=pox;
        poy=poy;
        radius=radius;
        startingAngle=startingAngle;
        addingAngle=addingAngle;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillArc(pox,poy,radius,radius,startingAngle,addingAngle);
    }

}
