package Pacman;

import Common.Collision;
import Common.HitBoxes;
import Common.KListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.random;

public class PacPanel extends Collision implements Runnable  {
    final int screenWidth = 490;
    final int screenHeight = 640;
    int rows = 27;
    int columns =35;
    boolean[][] grid =new boolean[rows][columns];




    float cellHeight=screenHeight/rows;
    float cellWidth = screenWidth/columns;
    final int FPS =60;
    KListener kListener= new KListener();
    Thread gameThread;
    int playerX = 233;
    int playerY = 460; // the prev number was 455
    int playerSpeedX = 0;
    int playerSpeedY = 0;
    int startingAngle = 45;
    int addingAngle = 270;
    int playerRadius = 20; // the prev number was 30
    float playerIndexX = playerX/cellWidth;
    float playerIndexY = (playerY/cellHeight);


    HitBoxes playerBox =new HitBoxes(playerX,playerY,playerRadius,playerRadius);
    HitBoxes box =new HitBoxes(100,100,100,100);
    private BufferedImage image;
    public PacPanel()
    {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                //each cell has a 20% chance of being an obstacle
                if (random() < .2) {
                    grid[row][column] = true;
                }
            }
        }

        try {
            image = ImageIO.read(new File("GraphicsAssignment/src/resources/images/Maze.png"));
        } catch (IOException e){
            System.out.println(e);
        }
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.addKeyListener(kListener);
        this.setFocusable(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() +drawInterval;
        while (gameThread != null)
        {
            long currentTime = System.nanoTime();
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - currentTime;
                remainingTime =remainingTime/1000000;
                if (remainingTime<0)
                {
                    remainingTime=0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update()
    {

       if(((int) playerIndexY > 0 & grid[(int) playerIndexY-1][(int) playerIndexX]) |((int) playerIndexY < rows-1 & grid[(int) playerIndexY+1][(int)playerIndexX])
               |((int) playerIndexX > 0 & grid[(int) playerIndexY][(int) playerIndexX-1])
               |((int) playerIndexX < columns-1 & grid[(int) playerIndexY][(int) playerIndexX+1]))
       { playerX += playerSpeedX;
        playerY += playerSpeedY;}
       else
       {
           playerSpeedX=0;
           playerIndexY=0;
       }

//        if(kListener.rightPressed && collided){
////            playerSpeedX = 2;
////            playerSpeedY = 0;
//            startingAngle = 45;
//            playerX+=playerSpeedX;
//            collided=false;
//        }
//
//        else if (kListener.leftPressed&&collided){
//            playerSpeedX = -2;
//            playerSpeedY = 0;
//            startingAngle = 225;
//            playerX+=playerSpeedX;
//            collided=false;
//        }
//
//        else if(kListener.upPressed&&collided){
//            playerSpeedX = 0;
//            playerSpeedY = -2;
//            startingAngle = 135;
//            playerY+=playerSpeedY;
//            collided=false;
//        }
//
//        else if(kListener.downPressed&&collided){
//            playerSpeedX = 0;
//            playerSpeedY = 2;
//            startingAngle = 315;
//            playerY+=playerSpeedY;
//            collided=false;
//        }
//        if(playerIndexX < columns-1 &&kListener.rightPressed && grid[(int) playerIndexY][(int) ++playerIndexX]){
//           playerX=-(2*playerSpeedX);
//       }
//        if(playerIndexX > 0 &&kListener.leftPressed && grid[(int) playerIndexY][(int) --playerIndexX]){
//            playerX=+(2*playerSpeedX);
//        }
//        if(playerIndexY > 0 &&kListener.upPressed && grid[(int) --playerIndexY][(int) playerIndexX]){
//            playerX=-(2*playerSpeedX);
//        }
//        if(playerIndexY < rows-1&&kListener.downPressed && grid[(int) ++playerIndexY][(int) playerIndexX]){
//            playerX=+(2*playerSpeedX);
//        }

        if(kListener.rightPressed){

            playerSpeedX = 2;
            playerSpeedY = 0;
            startingAngle = 45;
        }

        else if (kListener.leftPressed){

            playerSpeedX = -2;
            playerSpeedY = 0;
            startingAngle = 225;
        }

        else if(kListener.upPressed){
            playerSpeedX = 0;
            playerSpeedY = -2;
            startingAngle = 135;
        }

        else if(kListener.downPressed){
            playerSpeedX = 0;
            playerSpeedY = 2;
            startingAngle = 315;
        }

        if ((playerX - playerRadius) >= screenWidth-1){
            playerX = -playerRadius;
        }
        else if (playerX <= -playerRadius){
            playerX = screenWidth + playerRadius;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        PacPlayer pacPlayer =new PacPlayer(playerX,playerY,playerRadius,startingAngle,addingAngle, playerBox);
        //PacMaze pacMaze = new PacMaze();
        pacPlayer.draw(g);
        //pacMaze.draw(g);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                float cellX = cellWidth*column;
                float cellY = cellHeight*row;
                if (grid[row][column])
                {
                    g.setColor(Color.red);
                    g.fillRect((int) cellX, (int) cellY, (int) cellWidth, (int) cellHeight);
                }

                g.setColor(Color.yellow);
                g.drawRect((int) cellX, (int) cellY, (int) cellWidth, (int) cellHeight);
            }
        }

        g.dispose();
    }
}
