package DesignPattern.创建型模式.抽象工厂.供应商.GoodDoc;

import DesignPattern.创建型模式.抽象工厂.AbstractFactory;
import DesignPattern.创建型模式.抽象工厂.HtmlDocument;
import DesignPattern.创建型模式.抽象工厂.WordDocument;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:14
 */
public class GoodFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new GoodHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new GoodWordDocument();
    }
}
