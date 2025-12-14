package DesignPattern.行为型模式.策略;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Young
 * @Date: 2025/12/14 17:30
 */
public class PrimeDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(new BigDecimal("0.3").setScale(2, RoundingMode.DOWN));
    }
}
