package LeetCode.排序;

/**
 * @Author: Young
 * @Date: 2025/6/10 00:00
 * 堆排序
 */
public class HeapSort {


    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1️⃣ 构建最大堆（从第一个非叶子节点开始向下堆化）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2️⃣ 一个个将堆顶元素（最大值）交换到数组末尾，再重新堆化
        for (int i = n - 1; i >= 0; i--) {
            // 将堆顶元素交换到末尾
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新对堆顶进行堆化（此时堆大小是 i）
            heapify(arr, i, 0);
        }
    }

    // 将以 i 为根的子树调整为最大堆（n 是当前堆大小）
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;           // 假设当前是最大值
        int left = 2 * i + 1;      // 左子节点索引
        int right = 2 * i + 2;     // 右子节点索引

        // 如果左子节点更大
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 如果右子节点更大
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // 如果最大值不是根节点，交换并递归堆化
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归堆化被交换下去的子树
            heapify(arr, n, largest);
        }
    }
}

