package q146_LRU缓存;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/6/17 01:46
 * <p>
 * 实现本题的两种操作，需要用到一个哈希表和一个双向链表
 * <p>
 * accessOrder = true 按 访问顺序
 * 每次访问（如 get()、put() 替换、computeIfAbsent() 等）后，访问的键值对会被移动到末尾。
 * <p>
 * 最近访问的元素总在最后，最久未访问的元素在最前。
 * <p>
 * 适合用作：最近最少使用（LRU）缓存
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return  size() > capacity;
    }


}
