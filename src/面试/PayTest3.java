package 面试;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author: Young
 * @Date: 2025/11/28 18:09
 */


interface Payment3 {
    void pay(int amount);

    String getType();
}

class AliPay3 implements Payment3 {

    public static final String TYPE = "alipay";

    @Override
    public void pay(int amount) {
        System.out.println("使用支付宝支付：" + amount);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class WeChatPay3 implements Payment3 {

    public static final String TYPE = "wechat";

    @Override
    public void pay(int amount) {
        System.out.println("使用微信支付：" + amount);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class UnionPay3 implements Payment3 {

    public static final String TYPE = "union";

    @Override
    public void pay(int amount) {
        System.out.println("使用云闪付支付：" + amount);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class UnknownPay3 implements Payment3 {

    public static final String TYPE = "unknown";

    @Override
    public void pay(int amount) {
        System.out.println("未知支付方式");
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class PaymentFactory {

    private static final Map<String, Supplier<Payment3>> registry = new HashMap<>();

    static {
        // 初始化默认支付方式
        register(AliPay3.TYPE, AliPay3::new);
        register(WeChatPay3.TYPE, WeChatPay3::new);
        register(UnionPay3.TYPE, UnionPay3::new);
    }

    // 注册支付方式（扩展用）
    public static void register(String type, Supplier<Payment3> creator) {
        registry.put(type, creator);
    }

    // 获取支付方式
    public static Payment3 getPayment(String type) {
        return registry.getOrDefault(type, UnknownPay3::new).get();
    }
}

public class PayTest3 {
    public static void main(String[] args) {
        Payment3 p1 = PaymentFactory.getPayment("alipay");
        p1.pay(100);
        System.out.println(p1.getType());

        Payment3 p2 = PaymentFactory.getPayment("wechat");
        p2.pay(200);
        System.out.println(p2.getType());

        // 动态扩展新支付方式
        PaymentFactory.register("apple", () -> new Payment3() {
            @Override
            public void pay(int amount) {
                System.out.println("使用 Apple Pay 支付：" + amount);
            }

            @Override
            public String getType() {
                return "apple";
            }
        });

            Payment3 p4 = PaymentFactory.getPayment("apple");
        p4.pay(999);
        System.out.println(p4.getType());
        }
    }
