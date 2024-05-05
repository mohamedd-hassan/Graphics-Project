import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows extends JFrame implements ActionListener {
    JButton pacman;
    JButton pong;
    JPanel main;
    GamePanel gamePanel;
    Windows()
    {

        main= new JPanel();
        pong=new JButton();
        pacman= new JButton();
        pacman.setText("pacman");
        pacman.setFocusable(false);
        pacman.addActionListener(this);
        pacman.setBounds(250,200,10,50);
        pong.setText("pong");
        pong.setFocusable(false);
        pong.addActionListener(this);
        pong.setBounds(250,300,10,50);
        main.setSize(500,500);
        this.add(main);
        main.add(pacman);
        main.add(pong);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()== pacman)
         {
            this.dispose();
            PacFrame pacFrame=new PacFrame();

         }
        if (e.getSource()== pong)
        {
            this.dispose();
            PongFrame pacFrame=new PongFrame();

        }


    }
}
