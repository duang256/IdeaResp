package YY;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class Server {
    public static void main(String[] args) throws Exception {

        DatagramSocket server=new DatagramSocket(9999);

        while(true){
            byte[]container=new byte[1024*6];
            //DatagramPacket既可以发送包裹，又可以接收包裹
            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            server.receive(packet);
            byte[]datas=packet.getData();
            String str=new String(datas,0,datas.length);
            System.out.println(str);
            if(str.equals("bye")){
                break;
            }
        }










    }
}
