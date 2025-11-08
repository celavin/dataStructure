package Algorithms.a02Sort.b01ComparisonSort.insertSort;

import java.util.Arrays;
//插入排序,高中学过,很简单
//第一个默认为有序区,之后从左遍历取值,从有序区的末端一个个往左比,比待插入值大的往左移动一格
//直到遇到比待插入值小的.
//边界有点微妙,不过也不难
public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,4,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    static void sort(int[] nums){
        if(nums == null||nums.length <= 1){
            return;
        }
        insertSort(nums);
    }
    static void insertSort(int[] nums){
        int j;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            j=i-1;
            temp = nums[i];
            while(j>=0){
                if(nums[j]>temp){
                    nums[j+1]=nums[j];//move right
                    j--;
                }else{break;}
            }
            nums[j+1]=temp;

        }
    }

}
