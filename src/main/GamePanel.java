package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
    private int gameSpeed = 20;
    private Map map;
    private Timer timerSwing;
    private MouseInputs mouseInputs = new MouseInputs();
    public Player player;
    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        player = new Player(Color.RED);
        timerSwing = new Timer(5, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player.isJump) player.Jump();
                map.MoveMap(gameSpeed);
                repaint();
                if(map.endMap) timerSwing.stop();
            }
        });
        map = new Map(Color.CYAN, Color.green, 120);
        timerSwing.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        DrawMap(g);
        DrawPlayer(g);
    }

    public void DrawPlayer(Graphics g) {
        g.setColor(player.color);
        g.fillRect(player.x, player.y, player.w, player.h);
    }
    private int i;
    public void DrawMap(Graphics g) {
        //map.MoveMap(gameSpeed);
        map.GetIndexes(this.getWidth());
        g.setColor(map.bgColor);
        g.fillRect(0, 0, getWidth(), 500);
        g.setColor(map.fgColor);
        for(i = map.firstIndex; i< map.lastIndex; i++) {
            g.fillRect(map.objects[i], 450, 50, 50);
        }
        g.fillRect(0, 500, getWidth(), getHeight()-500);

    }

}
