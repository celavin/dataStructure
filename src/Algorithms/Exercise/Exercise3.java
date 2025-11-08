package Algorithms.Exercise;

import java.util.Arrays;

//手写三路快排
public class Exercise3 {
    public static void main(String[] args) {
        int[] nums = {3,  1,  7,  0,  8,  5,  8,  2,  8,  10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        threeWayQuickSort(nums,0,nums.length-1);
    }
    static void threeWayQuickSort(int[] nums,int low,int high){
        if(low<high){
            int[] border = partition(nums, low, high);
            threeWayQuickSort(nums,low,border[0]-1);
            threeWayQuickSort(nums,border[1]+1,high);
        }
    }
    static int[] partition(int[] nums,int low,int high){
        //牢记五个指针,四个区域
        int i = low+1;
        int pivot = nums[low];
        int lt = low;
        int gt = high;
        int temp;
        while(i<=gt){
            if(nums[i]<pivot){
                temp=nums[i];
                nums[i]=nums[lt];
                nums[lt]=temp;
                lt++;
                i++;
            } else if(nums[i]>pivot){
                temp=nums[i];
                nums[i]=nums[gt];
                nums[gt]=temp;
                gt--;//i这里不移动,因为当前值还没检测;
            }else{
                i++;
            }
        }
        return new int[]{lt,gt};

    }

}
