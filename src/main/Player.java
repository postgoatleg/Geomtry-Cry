package main;

import java.awt.Color;

public class Player {
    int x, y, w, h;
    int jumpStep = 1;
    public boolean isJump = false;
    Color color;
    public Player(Color color) {
        x = 100;
        y = 400;
        w = 100;
        h = 100;
        this.color = color;
    }

    private void ChangeY(int value) {
        this.y += value;
    }
    public int getY() {
        return this.y;
    }

    public void Jump() {
        if(jumpStep <= 20) {
            ChangeY((int)-Math.pow(jumpStep, 1.1));
            jumpStep++;
        }
        else if(jumpStep <= 40) {
            ChangeY((int)Math.pow(jumpStep-20, 1.1));
            jumpStep++;
        }
        else {
            jumpStep = 1;
            isJump = false;
        }
    }
}
