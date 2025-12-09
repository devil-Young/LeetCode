package q11_盛最多水的容器;

/**
 * @Author: Young
 * @Date: 2023/9/7 23:39
 */
public class Solution {
    public  int maxArea(int[] height){
        int l = 0, r = height.length-1;
        int ans = 0;
        while (l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans,area);
            if (height[l] <= height[r]){
                ++l;
            }else {
                --r;
            }
        }
        return ans;
    }
}
