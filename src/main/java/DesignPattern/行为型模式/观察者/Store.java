package DesignPattern.行为型模式.观察者;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Young
 * @Date: 2025/12/14 16:03
 * <p>
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * <p>
 * 观察者模式（Observer）又称发布-订阅模式（Publish-Subscribe：Pub/Sub）。
 * 它是一种通知机制，让发送通知的一方（被观察方）和接收通知的一方（观察者）能彼此分离，互不影响。
 *
 */

/*
public class Store {
    Customer customer;
    Admin admin;

    private Map<String, Product> products = new HashMap<>();

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        // 通知用户:
        customer.onPublished(p);
        // 通知管理员:
        admin.onPublished(p);
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        // 通知用户:
        customer.onPriceChanged(p);
        // 通知管理员:
        admin.onPriceChanged(p);
    }
}
*/

/*我们观察上述Store类的问题：它直接引用了Customer和Admin。先不考虑多个Customer或多个Admin的问题，上述Store类最大的问题是，如果要加一个新的观察者类型，例如工商局管理员，Store类就必须继续改动。

因此，上述问题的本质是Store希望发送通知给那些关心Product的对象，但Store并不想知道这些人是谁。观察者模式就是要分离被观察者和观察者之间的耦合关系。


要实现这一目标也很简单，Store不能直接引用Customer和Admin，相反，它引用一个ProductObserver接口，任何人想要观察Store，只要实现该接口，并且把自己注册到Store即可：   */




public class Store {

    private List<ProductObserver> observers = new ArrayList<>();
    private Map<String, Product> products = new HashMap<>();


    // 注册观察者
    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    // 取消注册
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        // 通知所有注册的观察者:
        for (ProductObserver observer : observers) {
            observer.onPublished(p);
        }
    }

/*    说明各个观察者是依次获得的同步通知，如果上一个观察者处理太慢，会导致下一个观察者不能及时获得通知。
此外，如果观察者在处理通知的时候，发生了异常，还需要被观察者处理异常，才能保证继续通知下一个观察者。

    思考：如何改成异步通知，使得所有观察者可以并发同时处理？*/

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        // 通知观察者:
        observers.forEach(o -> o.onPriceChanged(p));
    }

    public static void main(String[] args) {
        // observer:
        Admin admin = new Admin();
        Customer customer = new Customer();
        // store:
        Store store = new Store();
        // 注册观察者:
        store.addObserver(admin);
        store.addObserver(customer);
        // 发布新产品:
        store.addNewProduct("iPhone 15", 9999);
        // 修改产品价格:
        store.setProductPrice("iPhone 15", 1);


    }

}





