package DesignPattern.行为型模式.责任链;

import DesignPattern.行为型模式.观察者.CEOHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:23
 */
public class HandlerChain {
    // 持有所有Handler:
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    public boolean process(Request request) {
        // 依次调用每个Handler:
        for (Handler handler : handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                // 如果返回TRUE或FALSE，处理结束:
                System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }

    public static void main(String[] args) {
        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        // 处理请求:
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));
    }
}
