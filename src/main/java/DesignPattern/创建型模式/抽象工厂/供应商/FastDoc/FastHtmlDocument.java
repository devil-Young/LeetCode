package DesignPattern.创建型模式.抽象工厂.供应商.FastDoc;

import DesignPattern.创建型模式.抽象工厂.HtmlDocument;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:03
 */
public class FastHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return "FastDoc";
    }

    @Override
    public void save(Path path) throws IOException {
        System.out.println("FastHtmlDocument");
    }
}
