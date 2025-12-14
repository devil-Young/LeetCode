package DesignPattern.行为型模式.策略;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 17:22
 */
public class OverDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        // 满100减20优惠:
        return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO;

    }
}
