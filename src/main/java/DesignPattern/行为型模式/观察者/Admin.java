package DesignPattern.行为型模式.观察者;

/**
 * @Author: Young
 * @Date: 2025/12/14 16:42
 */

// 观察者
public class Admin implements ProductObserver{
    @Override
    public void onPublished(Product product) {
        System.out.println("Admin [Log] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        System.out.println("Admin [Log] on product price changed: " + product);
    }
}
