package Pong;

import Common.Collision;

import javax.swing.*;

public class PongFrame {

    public PongFrame() {

        JFrame pong = new JFrame();
        PongPanel gamePanel = new PongPanel();
        pong.add(gamePanel);
        pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pong.setResizable(false);
        pong.setTitle("Pong");
        pong.pack();
        pong.setLocationRelativeTo(null);
        pong.setVisible(true);
        gamePanel.startGameThread();
    }
}
