import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {
    final int screenWidth = 720;
    final int screenHeight = 640;
    final int FPS =60;
    KListener kListener= new KListener();
    Thread gameThread;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.addKeyListener(kListener);
        this.setFocusable(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() +drawInterval;
        while (gameThread != null)
        {
            long currentTime = System.nanoTime();
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime -System.nanoTime();
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

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Player player=new Player(100,100,50,45,270);
        player.draw(g);
        g.dispose();
    }
}
