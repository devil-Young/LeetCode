package DesignPattern.创建型模式.抽象工厂;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:00
 */

// Html文档接口:
public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}
