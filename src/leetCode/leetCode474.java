package leetCode;
/*给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 */
//动态规划 背包
//一遍过,这力量(不)属于我!
//说实话基本全靠自己
public class leetCode474 {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        int a0 ;
        int a1 ;

        for (int i = 0; i < strs.length; i++) {
            a0=0;
            for (char c : strs[i].toCharArray()) {
                if(c == '0'){
                    a0++;
                }
            }
            a1= strs[i].length()-a0;

            for (int j = m; j >= a0; j--) {
                for (int l = n; l >= a1; l--) {
                    dp[j][l] =Math.max( dp[j-a0][l-a1]+1,dp[j][l]);
                }
            }
        }


        return dp[m][n];
    }

}
