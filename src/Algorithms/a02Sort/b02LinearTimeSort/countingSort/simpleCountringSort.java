package Algorithms.a02Sort.b02LinearTimeSort.countingSort;

import java.util.Arrays;

//只能排纯数字,而且范围不大,直接用索引代表值
public class simpleCountringSort {
    public static void main(String[] args) {
        int[] nums ={3,7,5,5,7,2,1,1,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void sort(int[] nums){
        if(nums == null || nums.length<=1){
            return;
        }
        countingSort(nums);
    }
    static void countingSort(int[] nums){
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int[] count = new int[max+1];
        for (int v : nums) {
            count[v]+=1;
        }
        int c = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[c] = i;
                c++;
            }
        }
    }

}
