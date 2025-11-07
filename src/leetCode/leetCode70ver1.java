package leetCode;
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 */
//递归解法
//n=44超时
public class leetCode70ver1 {
    public int climbStairs(int n) {
        if(n==2){
            return 2;
        }
        else if(n==1){
            return 1;
        }

        return climbStairs(n-1)+climbStairs(n-2);

    }

}
