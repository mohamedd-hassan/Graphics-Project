package Pong;

import Common.Collision;
import Common.HitBoxes;
import Common.KListener;

import java.awt.*;

public class PongPanel extends Collision implements Runnable {
    final int screenWidth = 700;
    final int screenHeight = 600;
    final int FPS =60;
    KListener kListener= new KListener();
    Thread gameThread;

    int player1x=20;
    int player1y=250;
    int player2x=660;
    int player2y=250;
    int playerwidth=20;
    int playerheight=200;
    int player1SpeedY=0;
    int player2SpeedY=0;

    int ballx = 700/2;
    int bally= 600/2;
    int ballxspeed=3;
    int ballyspeed=3;
    int balldiameter = 25;
    int player1Score=0;
    int player2Score=0;
    Font myFont = new Font("Courier New",Font.BOLD,50);

    HitBoxes player1Box =new HitBoxes(player1x,player1y,playerwidth,playerheight);
    HitBoxes player2Box =new HitBoxes(player2x,player2y,playerwidth,playerheight);
    HitBoxes ballBox = new HitBoxes(ballx,bally,balldiameter,balldiameter);

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
        ballx+=ballxspeed;
        bally+=ballyspeed;
        if(collied(ballx,bally,balldiameter,balldiameter,player2x,player2y,playerwidth,playerheight))
        {
            ballxspeed = -ballxspeed;
            ballx+= ballxspeed -5 ;
            ballyspeed+=player2SpeedY;
            collided=false;
        }
         if (collied(ballx,bally,balldiameter,balldiameter,player1x,player1y,playerwidth,playerheight))
        {
            ballxspeed = -ballxspeed;
            ballx+= ballxspeed +10 ;
            ballyspeed+=player2SpeedY;
            collided=false;
        }

        if ((bally + balldiameter)-screenHeight>=0){
            ballyspeed = -ballyspeed ;
        }
        else if (bally <=0 ){
            ballyspeed = -ballyspeed;
        }
        if (ballx - balldiameter > screenWidth){
            ballx = screenWidth/2;
            bally= screenHeight/2;
            player1Score++;
        }
        if (ballx+balldiameter<0 ){
            ballx = screenWidth/2;
            bally= screenHeight/2;
            player2Score++;
        }
        if ((player2y + playerheight)-screenHeight>=0){
            player2y =  screenHeight - playerheight-5;
        }
        if(kListener.upPressed){
            player1SpeedY = -5;
            player1y+=player1SpeedY;
        }

        else if(kListener.downPressed){
            player1SpeedY = 5;
            player1y+=player1SpeedY;
        }
        if(kListener.arrowUpPressed){
            player2SpeedY = -5;
            player2y+=player2SpeedY;
        }

        else if(kListener.arrowDownPressed){
            player2SpeedY = 5;
            player2y+=player2SpeedY;
        }
        if ((player1y + playerheight)-screenHeight>=0){
            player1y =  screenHeight - playerheight-5;
        }
        else if (player1y <=0 ){
            player1y = 5;
        }
        if ((player2y + playerheight)-screenHeight>=0){
            player2y =  screenHeight - playerheight-5;
        }
        else if (player2y <=0 ){
            player2y = 5;
        }

        if(player1Score==1)
        {
            Winner1Frame winnerFrame = new Winner1Frame();
            gameThread.interrupt();

        }
        if(player2Score==1)
        {
            Winner2Frame winnerFrame = new Winner2Frame();
            gameThread.interrupt();

        }

    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        PongPlayer player1 = new PongPlayer(player1x,player1y,playerwidth,playerheight,player1Box);
        PongPlayer player2 = new PongPlayer(player2x,player2y,playerwidth,playerheight,player2Box);
        PongBall ball =new PongBall(ballx,bally,balldiameter,ballBox);
        g.setColor(Color.white);
        g.setFont(myFont);
        g.drawString(Integer.toString(player1Score),250,70);
        g.drawString(Integer.toString(player2Score),450,70);
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
        g.dispose();
    }
}


