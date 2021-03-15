package planeGame;

import org.w3c.dom.ls.LSOutput;
import sun.util.calendar.LocalGregorianCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.util.Date;

public class MyGameFrame extends JFrame {

    Image bg=GameUtil.getImage("images/bg.jpg");   //GameUtil 这个工具类使得图片可以被轻易使用
    Image planeImg=GameUtil.getImage("images/plane.png");
    Plane plane=new Plane(planeImg,600,700,10,planeImg.getWidth(null),planeImg.getHeight(null));
    Shell[]shells=new Shell[40];
    Shell2[]shells2=new Shell2[40];
    Explode explode;
    Date startTime=new Date();
    Date endTime;
     boolean collide=false;


    public static void main(String[] args) {
        MyGameFrame f=new MyGameFrame();
        f.launchFrame();
    }


    @Override     //这个方法不需要调用，可以自动执行
    public void paint(Graphics g) {
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);
        for(int i=0;i<40;i++){
            shells[i].draw(g);
            shells2[i].draw(g);
            collide=(shells[i].getRect().intersects(plane.getRect()))||(shells2[i].getRect().intersects(plane.getRect()));
            if(collide){
                if(explode==null) {
                    explode = new Explode(plane.x, plane.y);
                    endTime=new Date();
                }
                explode.draw(g);
                plane.live=false;
            }
        }
        if(explode!=null){
            Font f=g.getFont();
            Color c=g.getColor();
            g.setColor(Color.white);
            Font font=new Font("宋体",Font.BOLD,60);
            g.setFont(font);
            g.drawString("Game Over",600,500);
            g.drawString("Time:"+(int)((endTime.getTime()-startTime.getTime())/1000),50,800);
            g.setFont(f);
            g.setColor(c);

        }
    }


    public void launchFrame(){
        this.setTitle("Plane Game");  //两个自动的方法
        this.setVisible(true);
        this.setSize(1500,1000);
        this.setLocation(300,100);

        for(int i=0;i<40;i++){
            shells[i]=new Shell();
            shells2[i]=new Shell2();
        }

        //监听窗口的关闭线程
        this.addWindowListener(new WindowAdapter() {    //一个特殊的监听方法，也是自动执行
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //启动重画线程
        new PaintTread().start();
        //启动键盘的监听线程
        new KeyMonitor();
        addKeyListener(new KeyMonitor());//这个对着？



    }

    //重画线程
    class PaintTread extends Thread{
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //监控键盘线程
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }


    }



}
