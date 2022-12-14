import inputs.KeyboardInputs;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        addKeyListener(new KeyboardInputs());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(100, 400, 100, 100);
    }
}
