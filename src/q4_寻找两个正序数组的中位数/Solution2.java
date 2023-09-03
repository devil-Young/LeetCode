package q4_寻找两个正序数组的中位数;

/**
 * @Author: Young
 * @Date: 2023/9/3 21:48
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] num1, int[] num2){
        int n = num1.length;
        int m = num2.length;

        // 合并后的中位数位置
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(num1 , 0, n - 1, num2, 0, m - 1, left) + getKth(num1, 0, n - 1, num2, 0, m - 1, right)) * 0.5;

    }

    //相当于求第K小的数 第一小 第二小 第三小...
    private int getKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start1 + 1;

        // 让len1的长度一定小于len2，这样能保证数组空了，空的一定是len1
        if (len1 > len2){
            return getKth(num2, start2, end2, num1, start1, end1, k);
        }

        if (len1 == 0){
            return num2[start2 + k -1];
        }

        if (k == 1){
            return Math.min(num1[start1], num2[start2]);
        }

        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;

        if (num1[i] > num2[j]){
            return getKth(num1, start1, end1, num2, j + 1, end2, k - (j - start2 + 1));
        }else {
            return getKth(num1, i + 1, end1, num2, start2, end2, k - (i - start1 + 1));
        }
    }
}
