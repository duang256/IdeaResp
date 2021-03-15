package dynamicProxy;

import java.lang.reflect.Proxy;

public class Demo01 {
    public static void main(String[] args) {
        Wedding lovers=new Lovers();
        WeddingHandler handler=new WeddingHandler(lovers);

        Wedding proxy= (Wedding) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Wedding.class},handler);
        proxy.kiss();

    }
}
