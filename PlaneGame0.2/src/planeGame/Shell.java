package planeGame;

import java.awt.*;

import static java.lang.Math.PI;

public class Shell  extends GameObject{
    double  degree=Math.random()*2*Math.PI;;
    double x=200;
    double y=200;
    int width=10;
    int height=10;
    int speed=2;


    public void draw(Graphics g){   //画红色子弹   遇到边界反弹   各个方向发散
        Color c=g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x,(int)y,width,height);

        x+=speed*Math.cos(degree);
        y+=speed*Math.sin(degree);

        if(x<20||x>1490){
            degree= PI-degree;
        }
        if(y<20||y>990){
            degree=-degree;
        }

        g.setColor(c);
    }
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
