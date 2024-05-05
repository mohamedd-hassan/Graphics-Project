import javax.swing.*;
import java.awt.*;

public class PongPlayer extends JPanel {
    int Playerx ,Playery,Playerwidth,Playerheight;
    HitBoxes hitBoxes =new HitBoxes(Playerx ,Playery,Playerwidth,Playerheight);
    PongPlayer(int x, int y, int width , int hegiht,HitBoxes boxes)
    {
                Playerx =x;
                Playery=y;
                Playerwidth=width;
                Playerheight=hegiht;
                hitBoxes=boxes;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(Playerx,Playery,Playerwidth,Playerheight);
    }

}
