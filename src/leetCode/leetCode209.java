package leetCode;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Comparator;

/*给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。

 */
//要连续,所以不能排序
public class leetCode209 {
    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213, nums));
    }
    static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minlength = nums.length+1;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target){
                minlength = Math.min(minlength, j - i + 1);
                // 缩小窗口：左指针右移，sum减去左指针元素
                sum -= nums[i];
                i++;
            }
        }


        if(minlength==nums.length+1){
            return 0;
        }else {return minlength;}
    }
}
