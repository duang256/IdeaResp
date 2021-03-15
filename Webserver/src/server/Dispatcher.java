package server;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Dispatcher implements Runnable{
    private Socket client;
    private Request request;
    private Response response;
    private servlets servlet;
    private InputStream is;
    public Dispatcher(Socket client) {
        this.client=client;
        try {
            request=new Request(client);
            response=new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            is=client.getInputStream();
            WebApp webApp=new WebApp();
            servlet= (servlets) webApp.getServletFromUrl(request.getUrl());
            if(servlet!=null){
                servlet.service(request,response);

                //调用这个方法是整个构建运行的开始
                response.pushToBrowser(200);
                //下面的else是处理错误url的
            }else{
                InputStream is=Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("error.html");
                response.pushToBrowser(404);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
