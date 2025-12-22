package DesignPattern.创建型模式.单例;

/**
 * @Author: Young
 * @Date: 2025/12/23 01:03
 */

//另一种实现Singleton的方式是利用Java的enum，因为Java保证枚举类的每个枚举都是单例，所以我们只需要编写一个只有一个枚举的类即可
public enum World {
    // 唯一枚举
    INSTANCE;

    private String name = "world";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
