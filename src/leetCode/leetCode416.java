package leetCode;

import java.util.Arrays;

/*给你一个 只包含正整数 的 非空 数组 nums 。
请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。*/

//0/1背包问题,好巧妙!!!!!!!!!!!!!!!!
public class leetCode416 {
    public static void main(String[] args) {

    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum +=num;
        }
        if(sum%2==0){
            return false;
        }
        int target =sum/2;
        boolean[] dp = new boolean[target+1];

        dp[0] = true;
        for (int num : nums) {
            // 内层循环：遍历背包容量 (必须倒序)
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }



        return dp[target];
    }

}
