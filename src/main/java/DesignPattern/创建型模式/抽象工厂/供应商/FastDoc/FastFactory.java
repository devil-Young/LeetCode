package DesignPattern.创建型模式.抽象工厂.供应商.FastDoc;

import DesignPattern.创建型模式.抽象工厂.AbstractFactory;
import DesignPattern.创建型模式.抽象工厂.HtmlDocument;
import DesignPattern.创建型模式.抽象工厂.WordDocument;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:06
 */
public class FastFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
