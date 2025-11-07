package leetCode;
/*给你一个整数 n ，
求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
返回满足题意的二叉搜索树的种数。*/
//暴力递归解法
public class leetCode96ver1 {
    public static void main(String[] args) {

    }
    public int numTrees(int n) {
        int sum =0;
        if(n==2) return 2;
        if(n==1) return 1;
        if(n==0) return 1;
        for (int i = 1; i <= n; i++) {
            sum+= numTrees(i-1)*numTrees(n-i);
        }

        return sum;
    }
}
