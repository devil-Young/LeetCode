package q53_最大子数组和;

/**
 * @author ：Young
 * @date ：Created in 2022/2/21 11:25
 */

public class Solution {

    /**
     * 未做空间优化  动态规划
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
     * 优化空间  动态规划
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

    /**
     *  分治法  递归 2022年4月5日19:03:14
     */
    public int maxSubArray3(int[] nums){
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public class Status{
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
    //  l r 所求数组的左右索引
    public Status getInfo(int[] a, int l, int r){
        if (l == r){
            return new Status(a[l], a[l],a[l],a[l]);
        }
        int m = r + l >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    // 通过左区间和右区间 得到外层的大区间（左区间，右区间）
    public Status pushUp(Status l, Status r){
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        // b不跨越中间值m 跨越中间值m
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

}
