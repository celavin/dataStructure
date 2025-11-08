package leetCode;
/*在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。*/

//未完成.转移方程想不出来20251108
//这应该是2d的吗?
public class leetCodeQ38 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                if(dp[i][0]>max){
                    max = dp[i][0];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]=='1'){
                dp[0][i]=1;
                if(dp[0][i]>max){
                    max = dp[0][i];
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])
                            +1;
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }
        return max*max;
    }
}
