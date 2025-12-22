package DesignPattern.创建型模式.单例;

/**
 * @Author: Young
 * @Date: 2025/12/22 22:58
 */
public class Singleton {

    private Singleton() {
    }

    // 静态字段引用唯一实例
    private static final Singleton INSTANCE = new Singleton();

    public static  Singleton getInstance() {
        return  INSTANCE;
    }

}
