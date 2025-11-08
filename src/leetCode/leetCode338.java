package leetCode;
/*给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
返回一个长度为 n + 1 的数组 ans 作为答案。*/
public class leetCode338 {
    public static void main(String[] args) {
    }
    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if(i%2==0) dp[i] = dp[i >> 1];
            else dp[i] = dp[i >> 1] +1;
        }
        return dp;
    }
}
