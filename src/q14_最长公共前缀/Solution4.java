package q14_最长公共前缀;

/**
 * @Author: Young
 * @Date: 2023/9/9 17:43
 *
 * 二分查找
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str: strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high){
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)){
                low = mid;
            }else {
                high  = mid - 1;
            }
        }
        return strs[0].substring(0,low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (String s : strs) {
            for (int j = 0; j < length; j++) {
                String str = s;
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
