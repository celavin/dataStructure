package Algorithms.a02Sort.b01ComparisonSort.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));

    }
    static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        mergeSort(nums,0,nums.length-1);
    }
    static void mergeSort(int[] nums,int left,int right){
        if (left >= right) {
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private static void merge(int[] nums, int left, int mid, int right) {
        // 创建一个临时数组来存放合并后的结果
        int[] temp = new int[right - left + 1];

        int i = left;     // 指向左半部分有序数组的起始位置
        int j = mid + 1;  // 指向右半部分有序数组的起始位置
        int k = 0;        // 指向temp数组的起始位置

        // --- 核心比较逻辑 ---
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        // --- 处理剩余元素 ---
        // 如果左半部分还有剩余元素
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        // 如果右半部分还有剩余元素
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // --- 将临时数组的内容复制回原数组 ---
        for (int index = 0; index < temp.length; index++) {
            // 注意：是复制到原数组的 left + index 位置
            nums[left + index] = temp[index];
        }
    }
}
