package q763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/5 23:14
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] last= new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i; // 记录每个字母最后出现的位置
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1; // 更新下一个分区的起始位置
            }
        }
        return partition;
    }
}
