package Pong;

import Common.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Winner2Frame extends JFrame implements ActionListener {
    Font myFont = new Font("Courier New",Font.BOLD,50);
    JButton restart;
    JButton menu;
    JFrame pong = new JFrame();
    JLabel Winner =new JLabel();
    public Winner2Frame() {
        Winner.setText("The Winner is Player 2" );
        Winner.setFont(myFont);
        Winner.setForeground(Color.green);
        restart=new JButton();
        restart.setText("Restart");
        restart.setFocusable(false);
        restart.addActionListener((ActionListener) this);
        restart.setBounds(250,450,10,50);
        menu =new JButton();
        menu.setText("Main Menu");
        menu.setFocusable(false);
        menu.addActionListener((ActionListener) this);
        menu.setBounds(450,450,10,50);
        JPanel gamePanel = new JPanel();
        pong.add(gamePanel);
        pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pong.setResizable(false);
        pong.setTitle("Pong");
        pong.setSize(800,500);
        gamePanel.setBackground(Color.BLACK);
        pong.setLocationRelativeTo(null);
        pong.setVisible(true);
        gamePanel.add(restart);
        gamePanel.add(menu);
        gamePanel.add(Winner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart)
        {
            pong.dispose();
            PongFrame pongFrame =new PongFrame();

        }
        if (e.getSource() == menu)
        {
            pong.dispose();
            Windows windows =new Windows();
        }

    }
}
