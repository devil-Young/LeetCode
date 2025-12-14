package DesignPattern.行为型模式.责任链;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:14
 */
public interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
    Boolean process(Request request);
}
