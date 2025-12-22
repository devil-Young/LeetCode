package DesignPattern.创建型模式.单例;

/**
 * @Author: Young
 * @Date: 2025/12/23 01:09
 */
public class Singleton2 {

    private volatile static Singleton2 instance = null;

    private Singleton2() {

    }

    //对外提供获取该唯一实例的方法
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return  instance;
    }

}
