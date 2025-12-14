package DesignPattern.行为型模式.策略;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/14 17:07
 */

/*定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。

策略模式：Strategy，是指，定义一组算法，并把其封装到一个对象中。然后在运行时，可以灵活的使用其中的一个算法。*/


/*我们以购物车结算为例一个完整的策略模式要定义策略以及使用策略的上下文。我们以购物车结算为例，假设网站针对普通会员、Prime会员有不同的折扣，
同时活动期间还有一个满100减20的活动，这些就可以作为策略实现。先定义打折策略接口：*/
public interface DiscountStrategy {
    // 计算折扣额度
    BigDecimal getDiscount(BigDecimal total);
}
