package YY;

import javax.xml.stream.events.DTD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
   private int port;
   private String  toIP;
   private int toPort;
   private BufferedReader reader;
    DatagramSocket client=null;
    public TalkSend(int port, String toIP, int toPort) {
        this.port = port;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
             client=new DatagramSocket(port);

        } catch (SocketException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {

        while(true){
            reader=new BufferedReader(new InputStreamReader(System.in));
            String data= null;
            try {
                data = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[]datas=data.getBytes();
            DatagramPacket packet=new DatagramPacket(
                    datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
            try {
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }


            if(data.equals("bye")){
                break;
            }
        }
        client.close();
    }


}
