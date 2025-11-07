package leetCode;
//滚动数组版本
//mn行列有点混淆,将就着看
//因为每次都只用到[i-1]行的数据,之前的不需要了,所以可以用一维数组覆盖之前的值
public class leetCode62ver2 {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=1;
        }

        //这里解释一下dp[i]的含义,代表了到达第n行所需要的步数,至于是那一列要看循环执行次数

        for (int i = 1; i < m ; i++) {
            //i从1开始,因为i=0(即m=1)在上面已经初始化过了
            for (int j = 1; j < n ; j++) {
                //j从1开始,因为j=0(即n=1)的情况路径一定只有一条,所有dp[0]的值不需要改变
                dp[j] = dp[j-1] +dp[j];
                // dp[j-1] 是指 "本轮" (第i行) 的左侧格子
                // dp[j]   是指 "上轮" (第i-1行) 的上方格子 (值还未被覆盖)
            }
        }
        return dp[n-1];
    }
}
