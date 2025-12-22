package DesignPattern.创建型模式.抽象工厂;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:01
 */

// Word文档接口:
public interface WordDocument {
    void save(Path path) throws IOException;
}
