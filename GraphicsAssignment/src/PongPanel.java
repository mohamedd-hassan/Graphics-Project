import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PongPanel extends Collision implements Runnable {
    final int screenWidth = 720;
    final int screenHeight = 640;
    final int FPS =60;
    KListener kListener= new KListener();
    Thread gameThread;

    int player1x=20;
    int player1y=250;
    int playerwidth=20;
    int playerheight=200;
    int playerSpeedY;

    HitBoxes player1Box =new HitBoxes();

    public PongPanel()
    {
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

    public void update() {
        if(kListener.upPressed){
            playerSpeedY = -4;
            player1y+=playerSpeedY;
        }

        if(kListener.downPressed){
            playerSpeedY = 4;
            player1y+=playerSpeedY;
        }
        if ((player1y + playerheight)-screenHeight>=0){
            player1y =  screenHeight - playerheight-5;
        }
        else if (player1y <=0 ){
            player1y = 5;
        }

    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        PongPlayer player1 = new PongPlayer(player1x,player1y,playerwidth,playerheight,player1Box);
        player1.draw(g);
        g.dispose();
    }
}


