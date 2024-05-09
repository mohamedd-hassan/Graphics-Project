package Pacman;

import javax.swing.*;
import java.awt.*;

public class PacMaze extends JPanel {
    public void draw(Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        float thickness = 4;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(thickness));

        g.setColor(new Color(0, 27, 248));
//        g.fillRect(0,56, 490, 10);

        g2d.drawRoundRect(42,100,54,35, 15, 15);
        g2d.drawRoundRect(131,100,70,35, 15, 15);
        g2d.drawRoundRect(288,100,70,35, 15, 15);
        g2d.drawRoundRect(394,100,54,35, 15, 15);

//        g2d.drawRoundRect(233, 57, 23, 80, 15,10);

        g2d.drawRoundRect(42,170,54,18,15,15);
        g2d.drawRoundRect(394,170,54,18,15,15);

        g2d.drawRoundRect(131,326,18,70,15,15);
        g2d.drawRoundRect(340,326,18,70,15,15);

        g2d.drawRoundRect(131,432,70,19,15,15);
        g2d.drawRoundRect(288,432,70,19,15,15);


        g2d.drawPolygon(new int[]{130, 149, 149, 200, 200, 149, 149, 130}, new int[]{170, 170, 222, 222, 240, 240, 290, 290},8);
        g2d.drawPolygon(new int[]{359,340,340,290,290,340,340,359},new int[]{170, 170, 222, 222, 240, 240, 290, 290},8);

        g2d.drawPolygon(new int[]{},new int[]{},8);
        g2d.drawPolygon(new int[]{},new int[]{},8);
//
//        g2d.drawPolygon([],[],);
//        g2d.drawPolygon([],[],);
//
//        g2d.drawPolygon([],[],8);
//        g2d.drawPolygon([],[],8);
//        g2d.drawPolygon([],[],8);
    }
}
