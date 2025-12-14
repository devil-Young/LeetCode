package DesignPattern.行为型模式.模板方法;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/12/14 23:13
 */
public class LocalSetting extends AbstractSetting{

    private Map<String, String> cache = new HashMap<>();
    @Override
    protected String lookupCache(String key) {
        return cache.get(key);
    }

    @Override
    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        AbstractSetting setting1 = new LocalSetting();
        System.out.println("test = " + setting1.getSetting("test"));

        setting1.putIntoCache("test", "localValue");
        System.out.println("test = " + setting1.getSetting("test"));

    }
}
