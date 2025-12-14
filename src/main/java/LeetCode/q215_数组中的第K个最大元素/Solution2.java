package LeetCode.q215_数组中的第K个最大元素;

/**
 * @Author: Young
 * @Date: 2025/6/9 21:39
 * <p>
 * 方法二：基于堆排序的选择方法
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);

        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i); // 将最大元素放到数组末尾
            heapSize--; // 减小堆的大小
            maxHeapify(nums, 0, heapSize); // 重新调整堆
        }
        return  nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        // 构建最大堆
//        对于一个数组形式的完全二叉树：
//        第一个非叶子节点的索引是： n / 2 - 1（向下取整）

        //构建最大堆（从第一个非叶子节点开始向下堆化）
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    // 将以 i 为根的子树调整为最大堆（n 是当前堆大小）
    public void maxHeapify(int[] a, int i, int heapSize) {
        int largest = i; // 假设当前是最大值
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2;     // 右子节点索引

        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }

        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            // 交换当前节点和最大子节点
            swap(a, i, largest);

            // 递归调整子树 如果最大值不是根节点，交换并递归堆化
            maxHeapify(a, largest, heapSize);
        }


    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
