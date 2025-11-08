package Algorithms.a02Sort.b01ComparisonSort.HeapSort;

public class Demo1 {

    /**
     * 建堆过程：将无序数组构建为大顶堆
     * @param arr 待建堆的数组
     * @param length 堆的有效长度（初始为数组长度）
     */
    public static void buildHeap(int[] arr, int length) {
        // 从最后一个非叶子节点开始向前遍历，逐个调整节点
        // 最后一个非叶子节点的索引 = (length - 2) / 2（因为叶子节点从索引 (length/2) 开始）
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapify(arr, length, i); // 对当前节点执行下沉操作
        }
    }

    /**
     * 堆化（下沉）操作：调整节点使其符合大顶堆性质
     * @param arr 数组
     * @param length 堆的有效长度
     * @param i 当前需要调整的节点索引
     */
    private static void heapify(int[] arr, int length, int i) {
        int largest = i; // 初始化当前节点为最大值（父节点）
        int left = 2 * i + 1; // 左孩子索引
        int right = 2 * i + 2; // 右孩子索引

        // 若左孩子存在且大于父节点，则更新最大值索引
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        // 若右孩子存在且大于当前最大值，则更新最大值索引
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        // 若最大值不是当前节点（即需要交换）
        if (largest != i) {
            // 交换当前节点与最大值节点
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 递归调整被交换的孩子节点（可能破坏堆结构）
            heapify(arr, length, largest);
        }
    }

    // 测试建堆过程
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("建堆前的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // 执行建堆
        buildHeap(arr, arr.length);

        System.out.println("\n建堆后的大顶堆：");
        for (int num : arr) {
            System.out.print(num + " "); // 输出：10 5 3 4 1
        }
    }
}