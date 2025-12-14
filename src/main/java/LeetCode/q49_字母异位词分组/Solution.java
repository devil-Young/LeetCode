package LeetCode.q49_字母异位词分组;

import java.util.*;

/**
 * @Author: Young
 * @Date: 2023/12/23 23:50
 * 方法一 按字母排序
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 该方法接受两个参数：要查找的键和默认值。如果键存在，则返回与该键关联的值，否则返回指定的默认值
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
