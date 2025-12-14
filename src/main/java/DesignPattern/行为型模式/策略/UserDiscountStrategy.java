package DesignPattern.行为型模式.策略;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Young
 * @Date: 2025/12/14 17:20
 */
public class UserDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        // 普通会员打九折
        return total.multiply(new BigDecimal("0.1").setScale(2, RoundingMode.DOWN));
    }
}
