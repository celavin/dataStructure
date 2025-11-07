package leetCode;

import java.util.Arrays;

/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。*/
//动态规划
public class leetCode322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(coins==null) return -1;

        int[] dp = new int[amount+1];

        //一行代码完成初始化
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        /*for (int coin : coins) {//这个循环居然是多余的!!
            if(coin<=amount){
                dp[coin] = 1;}
        }*/

        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];// 三元运算符简化
    }
}
