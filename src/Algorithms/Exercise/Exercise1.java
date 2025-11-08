package Algorithms.Exercise;

import java.util.Arrays;

//手写归并排序
public class Exercise1 {
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
        if(left>=right){
            return;
        }
        int mid = left+right>>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    static void merge(int[] nums,int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int count = 0;
        while(i<=mid&&j<=right){
            if (nums[i] <= nums[j]) {
                temp[count]=nums[i];
                i++;
            }else{
                temp[count]=nums[j];
                j++;
            }
            count++;
        }
        if(i<=mid){
            while(i<=mid){
                temp[count]=nums[i];
                count++;
                i++;
            }
        }
        if(j<=right){
            while(j<=right){
                temp[count]=nums[j];
                count++;
                j++;
            }
        }
        for (int index = left; index <=right; index++) {
            nums[index]=temp[index-left];
        }
    }

}
