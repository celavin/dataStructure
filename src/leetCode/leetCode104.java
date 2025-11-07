package leetCode;
//爽了!
/*给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

 */
public class leetCode104 {
    public static void main(String[] args) {

    }
    static int maxDepth(TreeNode root) {
        if(root!=null){
            return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
        }
        return 0;
    }
}
