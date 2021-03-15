package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    private BufferedWriter bw;
    private StringBuilder content;
    private StringBuilder responseInfo;
    private int size;//正文的字节数
    private final String BLANK=" ";
    private final String CRLF="\r\n";

    public Response() {
        //正文内容
        content=new StringBuilder();
        //头信息
        responseInfo=new StringBuilder();
        //正文长度
        size=0;
    }

    public Response(Socket client) {
        this();
        try {
            //写入客户端输出流
            bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //暂时可以忽略
    public Response(OutputStream os) {
        this();
        bw=new BufferedWriter(new OutputStreamWriter(os));
    }



    //只要知道这个方法可以直接通过类写content就行了
    public Response println(String info){
        content.append(info);
        size+=(info+CRLF).getBytes().length;
        return this;
    }


    private void createResponseInfo(int code){
        responseInfo.append("HTTP/1.1").append(BLANK);
        responseInfo.append(200).append(BLANK) ;
        switch (code){
            case 200:responseInfo.append("OK").append(CRLF);
            case 404:responseInfo.append("NOT FOUND").append(CRLF);
        }
        responseInfo.append("Date:").append(new Date()).append(CRLF);
        responseInfo.append("Server:").append("yan Server/0.0.1;charset=GBK").append(CRLF);
        responseInfo.append("Content-type:text/html").append(CRLF);
        responseInfo.append("content-length:").append(size).append(CRLF);
        responseInfo.append(CRLF);
        responseInfo.append(content.toString());


    }

    public void pushToBrowser(int code) throws IOException {

        createResponseInfo(code);
        bw.append(responseInfo);
        bw.append(content);
        bw.flush();
    }








}
