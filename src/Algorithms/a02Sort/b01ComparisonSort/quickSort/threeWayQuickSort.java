package Algorithms.a02Sort.b01ComparisonSort.quickSort;

import java.util.Arrays;

public class threeWayQuickSort {
    public static void main(String[] args) {
         int[] nums = {3,  1,  7,  0,  8,  5,  8,  2,  8,  10};
         quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void quickSort(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }
        quickSort(nums,0,nums.length-1);
    }
    static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int[] border = partition(nums, low, high);
            quickSort(nums,low,border[0]-1);
            quickSort(nums,border[1]+1,high);
        }

    }
    static int[] partition(int[] nums,int low,int high){
        int[] border = new int[2];
        int lt = low,gt = high;
        int i = low+1;//哈基米居然胆敢质疑我
        int pivot = nums[low];
        int temp;
        while(i<=gt){
            // 为什么是等于?因为i和gt指向的值都没有被检测,当他们相等时仍然需要检测,i=gt+1时分别进入对方的区域,指向的值都被检测过了,所以此时该停止
            //也可以这样理解,只要未处理区域[i,gt]不为空,都要继续
            if(nums[i]<pivot){
                temp=nums[i];
                nums[i]=nums[lt];
                nums[lt]=temp;//swap nums[i] and nums[lt]
                i++;
                lt++;
            } else if (nums[i]>pivot) {
                temp=nums[i];
                nums[i]=nums[gt];
                nums[gt]=temp;//swap nums[i] and nums[gt]
                gt--;
            }else if(nums[i]==pivot){
                i++;
            }
        }
        border[0]=lt;
        border[1]=gt;

        return border;
    }
}
