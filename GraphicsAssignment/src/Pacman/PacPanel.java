package Pacman;

import Common.Collision;
import Common.HitBoxes;
import Common.KListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PacPanel extends Collision implements Runnable  {
    final int screenWidth = 720;
    final int screenHeight = 640;
    final int FPS =60;
    KListener kListener= new KListener();
    Thread gameThread;
    int playerX = 50;
    int playerY = 50;
    int playerSpeedX = 4;
    int playerSpeedY = 0;
    int startingAngle = 45;
    int addingAngle = 270;
    int playerRadius = 50;
    HitBoxes playerBox =new HitBoxes(playerX,playerY,playerRadius,playerRadius);
    HitBoxes box =new HitBoxes(100,100,100,100);
    private BufferedImage image;
    public PacPanel()
    {
        try {
            image = ImageIO.read(new File("GraphicsAssignment/src/resources/images/pacmanMaze.png"));
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
         CollisionCheck(playerX,playerY,playerRadius,playerRadius,300,300,100,100);
        playerX += playerSpeedX;
        playerY += playerSpeedY;
        if (collided)
        {
            playerSpeedX=0;
            playerSpeedY=0;
        }
        if(kListener.rightPressed && collided){
            playerSpeedX = 4;
            playerSpeedY = 0;
            startingAngle = 45;
            playerX+=playerSpeedX;
            collided=false;
        }

        else if (kListener.leftPressed&&collided){
            playerSpeedX = -4;
            playerSpeedY = 0;
            startingAngle = 225;
            playerX+=playerSpeedX;
            collided=false;
        }

        else if(kListener.upPressed&&collided){
            playerSpeedX = 0;
            playerSpeedY = -4;
            startingAngle = 135;
            playerY+=playerSpeedY;
            collided=false;
        }

        else if(kListener.downPressed&&collided){
            playerSpeedX = 0;
            playerSpeedY = 4;
            startingAngle = 315;
            playerY+=playerSpeedY;
            collided=false;
        }


        if(kListener.rightPressed){
            playerSpeedX = 4;
            playerSpeedY = 0;
            startingAngle = 45;
        }

        else if (kListener.leftPressed){
            playerSpeedX = -4;
            playerSpeedY = 0;
            startingAngle = 225;
        }

        else if(kListener.upPressed){
            playerSpeedX = 0;
            playerSpeedY = -4;
            startingAngle = 135;
        }

        else if(kListener.downPressed){
            playerSpeedX = 0;
            playerSpeedY = 4;
            startingAngle = 315;
        }

        if (playerX  == screenWidth + playerRadius){
            playerX = -playerRadius;
        }
        else if (playerX == -playerRadius){
            playerX = screenWidth + playerRadius;
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        PacPlayer pacPlayer =new PacPlayer(playerX,playerY,playerRadius,startingAngle,addingAngle, playerBox);
        PacPlayer pacPlayer1 =new PacPlayer(100,100,100,0,360,box);
        g.drawRect(300,300,100,100);
        pacPlayer.draw(g);
        pacPlayer1.draw(g);
        g.dispose();
    }
}
