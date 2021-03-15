package PlaneGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
飞机游戏主窗口
 */
public class MyGameFrame extends Frame {

    Image bg=GameUtil.getImage("images/bg.png");
    Image plane=GameUtil.getImage("images/plane.png");
    Plane pl=new Plane(plane,300,500);
    Shell[]shells=new  Shell[50];
    Explode bao;
    @Override
    public void paint(Graphics g) {   //自动被调用，g变量相当于一支画笔
        Color c=g.getColor();
        g.drawImage(bg,0,0,null);
        pl.drawSelf(g);
        for(int i=0;i<30;i++){
            shells[i].draw(g);
            boolean peng=shells[i].getRect().intersects(pl.getRect());
            if(peng){
                pl.live=false;

                if(bao==null){
                    bao=new Explode(pl.x,pl.y);
                }
                bao.draw(g);

            }

        }

    }






    class PaintThread extends Thread{   //反复重画窗口,这是一个内部类，可以调用外部类的东西
        @Override
        public void run() {
            while(true){
                repaint();  //重画

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class KeyMonitor extends KeyAdapter {    //键盘操作
        @Override
        public void keyPressed(KeyEvent e) {   //开始
            pl.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {//关闭
            pl.minusDirection(e);
        }
    }


    /**
     * 初始化窗口  //外框架位置，标题
     */
    public void launchFrame(){
        this.setTitle("B2");
        this.setVisible(true);
        this.setSize(1200,700);
        this.setLocation(200,50);
        this.addWindowListener(new WindowAdapter() {  //下面代码实现关闭窗口结束程序运行
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        new PaintThread().start();//启动重画窗口的线程
        addKeyListener(new KeyMonitor());//键盘监听
        //初始化100个炮弹
        for(int i=0;i<50;i++){
            shells[i]=new Shell();
        }
    }




    public static void main(String[] args) {       //主方法启动程序
        MyGameFrame f=new MyGameFrame();
        f.launchFrame();
    }
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(1200,700);

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
