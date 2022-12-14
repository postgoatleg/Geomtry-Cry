import javax.swing.*;

public class GameWindow extends JFrame {
     public GameWindow(GamePanel gamePanel) {

         setSize(1280,720);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         add(gamePanel);
         setVisible(true);
     }
}
