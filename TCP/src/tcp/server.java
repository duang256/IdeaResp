package tcp;

import javax.print.attribute.standard.MediaSize;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static tcp.server.all;
import static tcp.server.main;

/**
 * 服务器的工作准备就绪
 */
public class server {
     static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        //服务器应该是可以和多个客户端进行连接的
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            Socket client = serverSocket.accept();
            Channel c=new Channel(client);
            all.add(c);//管理所有成员
            new Thread(c).start();
        }
    }
}


//一个客户代表一个channel
class Channel implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning=true;
    private String name;

    public Channel( Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos= new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            release();
        }
    }

    //接收消息
    private  String receive()  {
        String msg="";
        try {
            msg=dis.readUTF();
        } catch (IOException e) {
            release();
        }
        return msg;

    }
    //发送消息  获取自己的消息发给其他人
    private void send(String msg){
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            release();
        }
    }

    private void sendOthers(String msg){
        System.out.println(msg);
        boolean isPrivate=msg.contains("@");
        if(isPrivate){
            int temp1=msg.indexOf("@");
            System.out.println(temp1);
            int temp2=msg.indexOf("？");
            System.out.println(temp2);
            String targetName=msg.substring(temp1+1,temp2);
            System.out.println(targetName);
            msg=msg.substring(temp2+1);
            for (Channel other:all
                 ) {
                if(other.name.equals(targetName)){
                    other.send(this.name+":"+msg);
                }
            }
        }else{
            for (Channel other:all
            ) {
                if(other==this){
                    continue;
                }else{
                    other.send(msg);
                }
            }
        }


    }


    //释放资源
    private void release(){
        this.isRunning=false;
        Utils.close(dis,dos,client);
    }

    @Override
    public void run() {
        this.name=receive();
        this.send("你进入群聊");
        sendOthers(name+"进入群聊");

        while(isRunning){
            String msg=receive();
            if(!msg.equals("")){
                sendOthers(name+":"+msg);
            }
        }
    }
}

