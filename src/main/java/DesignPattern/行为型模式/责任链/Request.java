package DesignPattern.行为型模式.责任链;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 22:09
 */
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
