package DesignPattern.行为型模式.责任链;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:20
 */
public class DirectorHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        return !request.getName().equalsIgnoreCase("tom");
    }
}
