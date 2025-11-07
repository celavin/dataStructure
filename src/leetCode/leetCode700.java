package leetCode;

import com.sun.source.tree.Tree;

import java.sql.PreparedStatement;

/*给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。
如果节点不存在，则返回 null 。*/
public class leetCode700 {
    public static void main(String[] args) {

    }
    TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return  null;
        }
        if(root.val==val){
            return root;
        }
        if(root.val<val){
            return searchBST(root.right,val);
        }
        else{
            return searchBST(root.left,val);
        }

    }
}
