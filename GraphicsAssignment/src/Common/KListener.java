package Common;

import java.awt.event.KeyEvent;

public class KListener implements java.awt.event.KeyListener {
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    public boolean arrowUpPressed, arrowDownPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
        if (code == KeyEvent.VK_W)
        {
            upPressed=true;
        }
        if (code == KeyEvent.VK_A)
        {
        leftPressed=true;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed=true;
        }
        if (code == KeyEvent.VK_D)
        {
        rightPressed=true;
        }
        if (code == KeyEvent.VK_UP)
        {
            arrowUpPressed=true;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            arrowDownPressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

       int code = e.getKeyCode();
        if (code == KeyEvent.VK_W)
        {
            upPressed=false;
        }
        if (code == KeyEvent.VK_A)
        {
            leftPressed=false;
        }
        if (code == KeyEvent.VK_S)
        {
            downPressed=false;
        }
        if (code == KeyEvent.VK_D)
        {
            rightPressed=false;
        }
        if (code == KeyEvent.VK_UP)
        {
            arrowUpPressed=false;
        }
        if (code == KeyEvent.VK_DOWN)
        {
            arrowDownPressed=false;
        }
    }
}
