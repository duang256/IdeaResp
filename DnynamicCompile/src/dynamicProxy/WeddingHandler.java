package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WeddingHandler implements InvocationHandler {
    Wedding Lovers;

    public WeddingHandler(Wedding lovers) {
        super();
        Lovers = lovers;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object=null;

            System.out.println("ready");
            if(method.getName().equals("kiss")){
                method.invoke(Lovers,args);
            }
            System.out.println("over");
            return object;
    }
}
