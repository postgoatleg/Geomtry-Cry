package main;

import java.awt.*;

public class Map {
    Color bgColor;
    Color fgColor;
    boolean endMap = false;
    int objects[];
    int firstIndex, lastIndex;
    public Map(Color bgColor, Color fgColor, int objNum) {
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        objects = new int[objNum];
        firstIndex = 0;
        lastIndex = objNum;
        fillMap();
    }

    public void fillMap() {
        for(int i = 0; i< objects.length; i++) {
            objects[i] = ((int)Math.round(Math.random()))*i*100;
            System.out.println(objects[i]);
        }
    }

    public void MoveMap(int speed) {
        for(i = firstIndex; i < objects.length; i++){
            objects[i] -= speed;
        }
    }
    int i;
    public void GetIndexes(int screenWidth) {
        i = 0;
        while(objects[i] < 0 && i < objects.length-1) i++;
        firstIndex = i;
        while(objects[i] <= screenWidth && i < objects.length-1) i++;
        lastIndex = i;
        if (firstIndex == lastIndex) endMap = true;
    }

}
