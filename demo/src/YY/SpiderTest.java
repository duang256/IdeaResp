package YY;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.*;

public class SpiderTest {

    public static void main(String[] args) throws IOException {
        //创建数据报套接字并将其绑定到  本地主机上的指定端口。
        DatagramSocket client=new DatagramSocket(8888);

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String data=reader.readLine();
            byte[]datas=data.getBytes();
            DatagramPacket packet=new DatagramPacket(
                    datas,0,datas.length,new InetSocketAddress("localhost",9999));
            client.send(packet);


            if(data.equals("bye")){
                break;
            }
        }
        client.close();
    }
}


