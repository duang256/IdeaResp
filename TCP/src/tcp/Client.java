package tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         System.out.println("请输入用户名：");
         String uname=br.readLine();
        Socket client=new Socket("localhost",8888);
        new Thread(new Send(client),uname).start();
        new Thread(new Receive(client)).start();
    }

}


