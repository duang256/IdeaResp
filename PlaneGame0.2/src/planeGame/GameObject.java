package planeGame;

import java.awt.*;

/**
 * 游戏物体父类
 */
public class GameObject {
     Image img;
     int x,y;
     int speed;
     int width,height;
     boolean live=true;

     public void drawSelf(Graphics g){
         g.drawImage(img,x,y,null);
     }

    public GameObject(Image img, int x, int y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    public GameObject(){

    }


}
