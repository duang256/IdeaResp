package PlaneGame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *飞机类  //over
 */

public class Plane extends GameObject{    //plane作为GO的子类继承了它的属性和方法
    boolean left,right,up,down;       //控制上下左右的四个开关
    boolean live=true;

    public Plane(Image img,double x,double y){//重写一个方法，传入x，y
        this.img=img;
        this.x=x;
        this.y=y;
    }
    public void drawSelf(Graphics g) {          //不停地画自己的方法
        if (live) {
            g.drawImage(img, (int) x, (int) y, null);
            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
        }else{

        }
    }
    public void addDirection(KeyEvent e){    //设置键入开关
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:left=true;break;
            case KeyEvent.VK_UP:up=true;break;
            case KeyEvent.VK_RIGHT:right=true;break;
            case KeyEvent.VK_DOWN:down=true;break;
        }
    }
    public void minusDirection(KeyEvent e){ //设置关闭开关
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:left=false;break;
            case KeyEvent.VK_UP:up=false;break;
            case KeyEvent.VK_RIGHT:right=false;break;
            case KeyEvent.VK_DOWN:down=false;break;
        }
    }
}
