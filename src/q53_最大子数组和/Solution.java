package q53_最大子数组和;

/**
 * @author ：Young
 * @date ：Created in 2022/2/21 11:25
 */

public class Solution {

    /**
     * 未做空间优化
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        // 从第二个位置开始
        for (int i = 1; i < len; i++) {
            if (dp[i -1] > 0){
                dp[i] = dp[i -1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res,dp[i]);
        }

        return res;
    }


    /**
     * 优化空间
     */
    public int maxSubArray2(int[] nums){
        int pre = 0;
        int res = nums[0];

        for (int num:nums) {
            pre = Math.max(pre, pre + num);
            res = Math.max(res,pre);
        }
        return res;
    }
}
