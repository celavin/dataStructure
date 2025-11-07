package leetCode;
//动态规划解法
public class leetCode96ver2 {
    public static void main(String[] args) {

    }


    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
