package leetCode;

/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），
并使这些整数的乘积最大化。
返回 你可以获得的最大乘积 。*/
//难道能用回溯?
//日超时了
public class leetCode343ver1 {
    public static void main(String[] args) {

    }
    int max = 0;
    int k = 0;
    public int integerBreak(int n) {
        backtrace(n,1,k);//m初始必须为1,不然后面很麻烦,现在要解决边界
        return max;
    }
    /**@ n 表示当前还剩下多少
     * @ m 表示当前的乘积
     * @ k 为了解决边界问题不得已引入的,只有一个作用,k==1时不改变max
     * */
    void backtrace(int n,int m,int k){
        if(k!=1&&n==0){
            if(m>max) max = m;
            return;
        }
        for (int i = 1; i <= n ; i++) {

            backtrace(n-i,m*i,k+1);
        }
    }

}
