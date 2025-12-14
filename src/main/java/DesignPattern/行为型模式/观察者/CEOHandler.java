package DesignPattern.行为型模式.观察者;

import DesignPattern.行为型模式.责任链.Handler;
import DesignPattern.行为型模式.责任链.Request;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:22
 */
public class CEOHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(50000)) > 0) {
            return Boolean.FALSE;
        }
        return !request.getName().equalsIgnoreCase("alice");
    }
}
