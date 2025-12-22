package DesignPattern.创建型模式.抽象工厂;

import DesignPattern.创建型模式.抽象工厂.供应商.FastDoc.FastFactory;
import DesignPattern.创建型模式.抽象工厂.供应商.GoodDoc.GoodFactory;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:18
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory fastFactory = new FastFactory();
        HtmlDocument fastHtml = fastFactory.createHtml("test");
        System.out.println(fastHtml.toHtml());

        AbstractFactory goodFactory = new GoodFactory();
        HtmlDocument goodHtml = goodFactory.createHtml("test");
        System.out.println(goodHtml.toHtml());

    }
}
