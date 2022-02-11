package q3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：Young
 * @date ：Created in 2022/2/11 8:49
 */

public class Solution {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
    // set集合记录遍历的字符 且可以判断是否有重复
        Set<Character> set = new HashSet<>();
        // 右指针    -1 代表在左边界的左侧
        int rp = -1;
        int res = 0; // 结果
        int n = s.length();
        for (int lp = 0; lp < n; lp++) {

            if(lp != 0){
                // 左指针向右移动
                set.remove(s.charAt(lp-1));
            }
            while (rp + 1 < n && !set.contains(s.charAt(rp + 1))){
                set.add(s.charAt(rp + 1));
                rp++;
            }
            res = Math.max(res, rp-lp+1);
        }

        return res;
    }

    /**
     * 改进方法 剔除无用的循环
     * while循环发现的重复字符不一定就是Set最早添加那个，
     * 还要好多次循环才能到达，这些都是无效循环

     */
    public int lengthOfLongestSubstring2(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int lp = 0;
        int res = 0;

        for (int rp = 0; rp < s.length(); rp++) {
            char ch = s.charAt(rp);

            if (map.containsKey(ch)){

                // map 中旧的数据没有移除 避免lp回去
                lp = Math.max(map.get(ch) + 1, lp);
            }

            res = Math.max(res, rp - lp + 1);
            // 利用了map的覆盖特性  省去了移除操作 同时也造成59行的写法
            map.put(ch,rp);

        }

        return res;
    }
}
