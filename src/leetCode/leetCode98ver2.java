package leetCode;
/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/

//写完感受一下,太巧妙了
public class leetCode98ver2 {
    public static void main(String[] args) {

    }
    static boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    static boolean isValidBST(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.val<=min){
            return false;
        }
        if(max!=null&&max<=root.val){
            return false;
        }

        return isValidBST(root.left,min,root.val)&&
                isValidBST(root.right,root.val,max);
    }

}
