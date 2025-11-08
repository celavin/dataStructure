package leetCode;
/*357. 统计各位数字都不同的数字个数
中等

给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。*/

//找出转移方程就很简单了,还可以优化空间
public class leetCode357ver1 {
    public static void main(String[] args) {

    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            int a = 9;
            int j = i-1;
            while(j!=0){
                a = a*(10-j);
                j--;
            }
            dp[i] = dp[i-1] + a;
        }
        return dp[dp.length-1];
    }

}
