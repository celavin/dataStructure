package Algorithms.a02Sort.b01ComparisonSort.bubbleSort;
/*给你一个整数数组 nums，请你将该数组升序排列。

你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。

 */
//n2
public class leetcode912 {
    public static void main(String[] args) {

    }
    public static int[] sortArrayBubble(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length-1-i ; j++) {
                if (nums[j] > nums[j+1]) {
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
    public static int[] sortArrayChoose(int[] nums) {
        int max;
        for (int i = 0; i < nums.length; i++) {
            max = i;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
        }



        return nums;
    }
}
