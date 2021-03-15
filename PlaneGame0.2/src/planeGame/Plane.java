package planeGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{



    public Plane(Image img, int x, int y, int speed, int width, int height) {
        super(img, x, y, speed, width, height);
    }


    boolean left,right,up,down;


    public void drawSelf(Graphics g) {
        if(this.live){
            g.drawImage(img,x,y,null);
        }

        if(up){
            y-=speed;
        }
        if(down){
            y+=speed;
        }
        if(left){
            x-=speed;
        }
        if(right){
            x+=speed;
        }
    }







    public void addDirection(KeyEvent e){
        
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
        }


    }

    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
        }
    }
    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

}
