package Algorithms.a02Sort.b02LinearTimeSort.bucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    /**
     * 桶排序的标准实现
     * @param arr 待排序的整型数组
     */
    public static void sort(int[] arr) {
//        // 1. 处理边缘情况
//        if (arr == null || arr.length < 2) {
//            return;
//        }

        // 2. 找到数组的 min 和 max
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 3. 处理特殊情况：所有元素都一样
        if (min == max) {
            return;
        }

        // 4. 初始化桶
        //    "标准"策略：桶的数量 k = 元素数量 n
        int n = arr.length;
        int bucketCount = n;

        // Java 中使用 List<List<Integer>> 来实现桶
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 5. 分发 (Scatter): 将元素放入对应的桶中
        //    我们使用 double 来确保映射除法的精度
        double range = (double)(max - min);

        for (int value : arr) {
            // 计算映射函数 (Normalization)
            // (value - min) / (max - min) -> 归一化到 [0.0, 1.0]
            // ... * (bucketCount - 1)     -> 映射到桶索引 [0, k-1]
            int bucketIndex = (int) ( ((double)(value - min) / range) * (bucketCount - 1) );

            // 放入对应的桶
            buckets.get(bucketIndex).add(value);
        }

        // 6. 桶内排序 (Sort): 对每个桶进行单独排序
        for (List<Integer> bucket : buckets) {
            // 在 Java 中，直接使用 Collections.sort() (Timsort)
            // 效率很高，且是稳定的
            Collections.sort(bucket);
        }

        // 7. 收集 (Gather): 按顺序从桶中取回元素
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    // --- 主函数用于测试 ---
    public static void main(String[] args) {
        System.out.println("--- 桶排序测试 ---");

        // 测试用例 1: 普通情况
        int[] nums1 = {4, 7, 1, 3, 5, 2, 6, 4};
        System.out.println("原始: " + Arrays.toString(nums1));
        sort(nums1);
        System.out.println("排序后: " + Arrays.toString(nums1));

        // 测试用例 2: 包含负数
        int[] nums2 = {-3, -1, 5, 0, -5, 2};
        System.out.println("\n原始: " + Arrays.toString(nums2));
        sort(nums2);
        System.out.println("排序后: " + Arrays.toString(nums2));

        // 测试用例 3: 分布不均
        int[] nums3 = {1, 2, 3, 100, 101, 102};
        System.out.println("\n原始: " + Arrays.toString(nums3));
        sort(nums3);
        System.out.println("排序后: " + Arrays.toString(nums3));

        // 测试用例 4: 所有元素相同
        int[] nums4 = {5, 5, 5, 5};
        System.out.println("\n原始: " + Arrays.toString(nums4));
        sort(nums4);
        System.out.println("排序后: " + Arrays.toString(nums4));
    }
}