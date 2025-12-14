package DesignPattern.行为型模式.观察者;

/**
 * @Author: Young
 * @Date: 2025/12/14 16:13
 */
public interface ProductObserver {

    void onPublished(Product product);

    void onPriceChanged(Product product);

//    有些观察者模式把通知变成一个Event对象，从而不再有多种方法通知，而是统一成一种：
//    void onEvent(ProductEvent event);
}
