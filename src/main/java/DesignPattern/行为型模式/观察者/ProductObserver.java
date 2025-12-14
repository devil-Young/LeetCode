package DesignPattern.行为型模式.观察者;

/**
 * @Author: Young
 * @Date: 2025/12/14 16:13
 */
public interface ProductObserver {

    void onPublished(Product product);

    void onPriceChanged(Product product);
}
