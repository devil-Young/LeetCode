package 面试;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

/**
 * @Author: Young
 * @Date: 2025/11/28 01:27
 */

interface Payment {
    void pay(int count);

}

/**
 * 支付宝
 **/
class AliPay implements Payment {

    @Override
    public void pay(int count) {
        System.out.println("使用支付宝支付" + count + "元");
    }
}

/**
 * 微信支付
 **/
class WeChatPay implements Payment {

    @Override
    public void pay(int count) {
        System.out.println("使用微信支付" + count + "元");
    }
}

/**
 * 银联支付
 **/
class UnionPay implements Payment {

    @Override
    public void pay(int count) {
        System.out.println("使用银联支付" + count + "元");
    }
}

class UnkonwnPay implements Payment {

    @Override
    public void pay(int count) {
        System.out.println("未选定支付方式，请选定后尝试");
    }
}

 class  PayFactory1 {

    public static Payment getInstance(String type) {
        if ("AliPay".equals(type)) {
            return new AliPay();
        } else if ("WeChatPay".equals(type)) {
            return new WeChatPay();
        } else if ("UnionPay".equals(type)) {
            return new UnionPay();
        }
        return new UnkonwnPay();
    }
}

class payFactory2 {
    public static <T extends Payment> T getInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            return (T) new UnkonwnPay();
        }
    }
}


public class PayTest {

    public static void main(String[] args) {
        Payment payment = payFactory2.getInstance(AliPay.class);
        Payment payment2 = payFactory2.getInstance(WeChatPay.class);
        payment.pay(18);
        payment2.pay(19);


    }

}



