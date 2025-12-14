package DesignPattern.创建型模式.FactoryMethod;

import java.math.BigDecimal;

/**
 * @Author: Young
 * @Date: 2025/12/9 18:04
 */
public class NumberFactoryImp implements NumberFactory{
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }

    public static void main(String[] args) {
        NumberFactory numberFactory = NumberFactory.getNumberFactory();
        Number number = numberFactory.parse("123.45");
        System.out.println(number);

        Number number1 = NumberFactorySimple.parse("678.90");
        System.out.println(number1);
    }
}

class  NumberFactorySimple {
    public static Number parse(String s){
        return new BigDecimal(s);
    }
}
