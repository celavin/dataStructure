package leetCode;
//动态规划解法
public class leetCode70ver2 {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        if(n>=2){
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }}
        return dp[n];
    }
}
