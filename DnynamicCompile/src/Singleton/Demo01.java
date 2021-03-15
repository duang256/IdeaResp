package Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式单例模式
 */
public class Demo01 {
    //类初始化时立即加载对象
    private static Demo01 instance=new Demo01();
    private Demo01(){
    }
    public static Demo01 getInstance(){
        return instance;
    }

}







