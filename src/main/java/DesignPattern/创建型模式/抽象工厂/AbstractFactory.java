package DesignPattern.创建型模式.抽象工厂;

/**
 * @Author: Young
 * @Date: 2025/12/20 23:59
 */

//假设我们希望为用户提供一个Markdown文本转换为HTML和Word的服务

public interface AbstractFactory {
    // 创建Html文档:
    HtmlDocument createHtml(String md);
    // 创建Word文档:
    WordDocument createWord(String md);
}

/*
public interface AbstractFactory {
    public static AbstractFactory createFactory(String name) {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }
}*/
