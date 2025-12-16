package LeetCode.q287_寻找重复数;

/**
 * @Author: Young
 * @Date: 2025/12/16 23:07
 * <p>
 * 快慢指针 转化为环形链表问题 检测环形链表的入口节点
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        //快慢指针
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow]; // 等价于 slow = slow.next
            fast = nums[nums[fast]];  // 等价于 fast = fast.next.next

            if (slow == fast) {
                break;
            }
        }

        int head = 0;
        while (head != slow) {
            slow = nums[slow];
            head = nums[head];
        }
        return slow; // 入环口即重复元素
    }
}
