package DesignPattern.行为型模式.责任链;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:14
 */
public class ManagerHandler implements Handler {

    // 如果超过1000元，处理不了，交下一个处理:
    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            System.out.println("Manager处理了请求，金额：" + request.getAmount());
            return null;
        }

        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}
