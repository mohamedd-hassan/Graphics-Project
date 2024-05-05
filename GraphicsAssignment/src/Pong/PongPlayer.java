package Pong;

import Common.HitBoxes;

import javax.swing.*;
import java.awt.*;

public class PongPlayer extends JPanel {
    int playerX, playerY, playerWidth, playerHeight;
    HitBoxes hitBoxes =new HitBoxes(playerX, playerY, playerWidth, playerHeight);
    PongPlayer(int x, int y, int width , int height,HitBoxes boxes)
    {
                playerX =x;
                playerY =y;
                playerWidth =width;
                playerHeight =height;
                hitBoxes=boxes;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }

}
