package PlaneGame;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

/**
 * 游戏物体的父类  //已处理
 */
public class GameObject {
     Image img;//物体图片
     double x,y;      //坐标
     int speed=4;      //移动时加减的坐标数
     int width=10,height=10;

     public void drawSelf(Graphics g){      //画出游戏物体
         g.drawImage(img,(int)x,(int)y,null);
     }



    public GameObject(Image img, double x, double y, int speed, int width, int height) {   //构造器接受子类对象的属性
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {     //重载方法，set部分属性
        this.img = img;
        this.x = x;
        this.y = y;
    }
    public GameObject(){

    }


    public Rectangle getRect(){         //撞机时调用
         return new Rectangle((int)x,(int)y,width,height);
    }
}
