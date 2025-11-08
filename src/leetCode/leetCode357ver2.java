package leetCode;
/*357. 统计各位数字都不同的数字个数
中等

给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。*/

//空间优化版本
public class leetCode357ver2 {
    public static void main(String[] args) {

    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int prev = 10 ;
        for (int i = 2; i <= n; i++) {
            int a = 9;
            for (int k = 1; k < i; k++) {
                a = a*(10-k);
            }
            prev = prev + a;
        }
        return prev;
    }

}
