package 面试;

/**
 * @Author: Young
 * @Date: 2025/11/28 02:05
 */


interface Payment2 {
    void pay(int count);
    String getType();
}

class AliPay2 implements Payment2 {
    public static final String TYPE = "AliPay";

    @Override
    public void pay(int count) {
        System.out.println("使用支付宝支付：" + count);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class WeChatPay2 implements Payment2 {
    public static final String TYPE = "WeChatPay";

    @Override
    public void pay(int count) {
        System.out.println("使用微信支付：" + count);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

 class UnionPay2 implements Payment2 {
    public static final String TYPE = "UnionPay";

    @Override
    public void pay(int count) {
        System.out.println("使用云闪付支付：" + count);
    }

    @Override
    public String getType() {
        return TYPE;
    }
}

class UnkonwnPay2 implements Payment2 {
    public static final String TYPE = "UnkonwnPay";
    @Override
    public void pay(int count) {
        System.out.println("未选定支付方式，请选定后尝试");
    }
    @Override
    public String getType() {
        return TYPE;
    }
}

 class PayFactory {

    public static Payment2 getInstance(String type) {
        return switch (type) {
            case AliPay2.TYPE -> new AliPay2();
            case WeChatPay2.TYPE -> new WeChatPay2();
            case UnionPay2.TYPE -> new UnionPay2();
            default -> new UnkonwnPay2();
        };
    }
}
public class PayTest2 {
    public static void main(String[] args) {
        Payment2 payment2 = PayFactory.getInstance("AliPay");
        payment2.pay(100);
    }
}

