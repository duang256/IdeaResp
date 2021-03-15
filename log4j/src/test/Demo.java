package test;


import org.apache.log4j.Logger;

public class Demo {
    public static void main(String[] args) {
        //获取log4j对象
        Logger logger=Logger.getLogger(Demo.class);
        logger.debug("我是debug信息");
        logger.info("我是info信息");
        logger.warn("我是警告信息");
        logger.error("我是错误信息");
        logger.fatal("我是致命错误");


    }

}
