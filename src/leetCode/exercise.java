package leetCode;
//计算树里面多少个节点,后序遍历
public class exercise {
    static int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum = countNodes(root.left);
        int righsum = countNodes(root.right);
        return 1+leftsum+righsum;
    }

}
