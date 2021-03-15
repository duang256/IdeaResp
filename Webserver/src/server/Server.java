package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }


    //启动服务
    public void start(){
        try {
            serverSocket=new ServerSocket(8888);
            isRunning=true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //接受连接处理
    public void receive() throws Exception {
        while(isRunning){
            Socket client=serverSocket.accept();
            new Thread(new Dispatcher(client)).start();

        }

    }
    //停止服务
    public void stop(){
        isRunning=false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}