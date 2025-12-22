package DesignPattern.创建型模式.抽象工厂.供应商.GoodDoc;

import DesignPattern.创建型模式.抽象工厂.WordDocument;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:13
 */
public class GoodWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws IOException {
        System.out.println("GoodWordDocument");
    }
}
