package DesignPattern.创建型模式.工厂方法;

/**
 * @Author: Young
 * @Date: 2025/12/9 17:54
 */
public interface NumberFactory {
    Number parse(String s);

    static NumberFactory getNumberFactory(){
        return new NumberFactoryImp();
    }
}
