package Algorithms.Exercise;

import java.util.Arrays;

//手写快速排序
public class Exercise2 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
    static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        quickSort(nums,0,nums.length-1);

    }
    static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int border = partition(nums, low, high);
            quickSort(nums,low,border-1);
            quickSort(nums,border+1,high);
        }
    }
    static int partition(int[] nums,int low,int high){
        //还是用挖坑法,直观
        int pivot = nums[low];
        while(low<high){
            while(low<high&&pivot<=nums[high]){
                high--;
            }
            nums[low]=nums[high];
            while (low < high && nums[low]<=pivot) {
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }
}
