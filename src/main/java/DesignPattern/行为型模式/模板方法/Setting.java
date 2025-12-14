package DesignPattern.行为型模式.模板方法;

/**
 * @Author: Young
 * @Date: 2025/12/14 23:06
 */

/*模板方法（Template Method）是一个比较简单的模式。它的主要思想是，
定义一个操作的一系列步骤，对于某些暂时确定不下来的步骤，就留给子类去实现好了，这样不同的子类就可以定义出不同的步骤。

因此，模板方法的核心在于定义一个“骨架”。*/
public class Setting {
    public final String getSetting(String key) {
        String value = readFromDatabase(key);
        return value;
    }

    private String readFromDatabase(String key) {
        // TODO: 从数据库读取
        return key;
    }

}
