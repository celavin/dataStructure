package Algorithms.a02Sort.b01ComparisonSort.quickSort;

import java.util.Arrays;

//挖坑法,并非hoare
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        quickSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
    static void quickSort(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }
        quickSort(nums,0,nums.length-1);
    }
    static void quickSort(int[] nums, int low, int high){
        if(low<high) {
            int border = partition(nums, low, high);
            quickSort(nums,low,border-1);
            quickSort(nums,border+1,high);
        }


    }
    static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low<high){
            while(low<high&&pivot<=nums[high]){//这里得写等于,狗屎的ds阴我
                high--;
            }
            nums[low]=nums[high];
            while(low<high&&nums[low]<=pivot){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }

}
