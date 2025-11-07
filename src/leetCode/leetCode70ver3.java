package leetCode;
//动态规划进阶 滚动数组 优化空间O(1)
public class leetCode70ver3 {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        if(n>1){
            int tmp;
            for (int i = 2; i <= n; i++) {
                tmp = b;
                b=a+b;
                a = tmp;
            }
        }
        return b;
    }
}
