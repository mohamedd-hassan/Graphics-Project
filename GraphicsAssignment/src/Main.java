import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
       JFrame window =new JFrame();
       Windows mainMenu=new Windows();
       mainMenu.setVisible(true);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setResizable(false);
       window.setTitle("PlaceHolder");
       GamePanel gamePanel =new GamePanel();
       window.add(gamePanel);
       window.pack();
       window.setLocationRelativeTo(null);
       window.setVisible(false);
       gamePanel.startGameThread();
    }
}