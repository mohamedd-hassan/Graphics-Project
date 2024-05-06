package Pong;

import javax.swing.*;

public class WinnerFrame {
    public WinnerFrame() {
        JFrame pong = new JFrame();
        JPanel gamePanel = new JPanel();
        pong.add(gamePanel);
        pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pong.setResizable(false);
        pong.setTitle("Pong");
        pong.setSize(800,500);
        pong.setLocationRelativeTo(null);
        pong.setVisible(true);
    }
}
