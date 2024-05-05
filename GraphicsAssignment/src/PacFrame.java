import javax.swing.*;

public class PacFrame  {
    PacFrame()
    {
        JFrame pacman=new JFrame();
        GamePanel gamePanel=new GamePanel();
        pacman.add(gamePanel);
        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setResizable(false);
        pacman.setTitle("Pacman");
        pacman.pack();
        pacman.setLocationRelativeTo(null);
        pacman.setVisible(true);
        gamePanel.startGameThread();

    }

}
