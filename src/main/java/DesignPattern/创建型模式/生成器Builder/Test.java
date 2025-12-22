package DesignPattern.创建型模式.生成器Builder;

import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/12/21 00:35
 */
public class Test {

    public static void main(String[] args) {
        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.liaoxuefeng.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }
}
