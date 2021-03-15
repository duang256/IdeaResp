package YY;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    private String fromName;
    private int port;
    DatagramSocket server;
    public TalkReceive(int port,String fromName) {
        this.fromName=fromName;
        this.port = port;
        try {
             server=new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            byte[]container=new byte[1024*6];
            //DatagramPacket既可以发送包裹，又可以接收包裹
            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            try {
                server.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[]datas=packet.getData();
            String str=new String(datas,0,datas.length);
            System.out.println(fromName+ ":"+str);
            if(str.equals("bye")){
                break;
            }
        }
    }
}
