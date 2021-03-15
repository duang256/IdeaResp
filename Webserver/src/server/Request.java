package server;
//这个类用来接收客户端信息，分析处理其中的信息，得到
// 请求参数，请求方式，请求url
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

public class Request {
    private  String str;
    //请求方式
    private  String method;
    //请求url
    private String url;
    //请求参数
    private String queryStr;
    private  String CRLF="\r\n";
    private Map<String , List<String >> parameterMap;



    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }


    public String getQueryStr() {
        return queryStr;
    }



    public Request(InputStream is){
        parameterMap=new HashMap<>();
        byte[]datas=new byte[1024*1024];
        int len= 0;
        try {
            len = is.read(datas);
             str=new String(datas,0,len);
             //调用拆分三大件
             parseRequestInfo();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }



    private void parseRequestInfo(){
        System.out.println(str);
        //这个方法提取字符串中部分内容
        this.method=this.str.substring(0,this.str.indexOf("/")).toLowerCase();
        int idx1=this.str.indexOf("/")+1;
        int idx2=this.str.indexOf("HTTP/")-1;
        this.url=this.str.substring(idx1,idx2);
        //这个方法如果存在就返回它的位置，如果不存在就返回-1，可以通过正负判断它是否存在
        int queryIdx=this.url.indexOf("?");
        if(queryIdx>0){
            String []urlArray=this.url.split("\\?");
            this.url=urlArray[0];
            this.queryStr=urlArray[1];
        }


        if(this.method.equals("post")){
            String qStr=this.str.substring(this.str.lastIndexOf(CRLF)).trim();
                queryStr=qStr;
        }

        queryStr=queryStr==null?"":queryStr;

        //调用拆分参数
        convertMap();


    }

    //处理请求参数   例子fav=1&fav=2&uname=Yui Hatano&uname=zhou
    private void convertMap(){
        String []keyValues=this.queryStr.split("&");
        //第一次分割
        for (String query:keyValues
             ) {
         //再次分割
            String []kv=query.split("=");
            kv= Arrays.copyOf(kv,2);
            //获取key，value
            String key=kv[0];
            String value=kv[1]==null?null:decode(kv[1]);

            if(!parameterMap.containsKey(key)){
                List<String >list=new ArrayList();
                parameterMap.put(key,list);
            }
            parameterMap.get(key).add(value);
        }
    }

    public String[] getParameterValues(String key){
        List<String>values=this.parameterMap.get(key);
        if(values==null||values.size()<1){
            return null;
        }
        //返回value数组
        return values.toArray(new String[0]);
    }
    //知道只有一个值，只获取一个值
    public String getParameterValue(String key){
       String []values= getParameterValues(key);
       return  values==null?null:values[0];
    }

    //处理中文
    private String decode(String value){
        try {
            return java.net.URLDecoder.decode(value,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }



}
