package Pacman;

import javax.swing.*;

public class PacFrame  {
    public PacFrame()
    {
        JFrame pacman = new JFrame();
        PacPanel pacPanel = new PacPanel();
        pacman.add(pacPanel);
        pacman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pacman.setResizable(false);
        pacman.setTitle("Pacman");
        pacman.pack();
        pacman.setLocationRelativeTo(null);
        pacman.setVisible(true);
        pacPanel.startGameThread();

    }
}
