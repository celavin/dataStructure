package leetCode;
/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/

//失败版本,原因是定义不清楚,
//root 的整个左子树（所有后代，不只是左孩子）都必须小于 root.val。
//root 的整个右子树（所有后代，不只是右孩子）都必须大于 root.val。
public class leetCode98ver1 {
    public static void main(String[] args) {

    }
    static boolean isValidBST(TreeNode root) {
        /*if(root.left!=null){
            isValidBST(root.left);
        }
        if(root.right!=null){
            isValidBST(root.right);
        }
        if(root.left.val<=root.val&&root.val<=root.right.val) return true;
        else return false;*/
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = true;
        if(root.left!=null&&root.left.val>=root.val){
            a= false;
        }
        if(root.right!=null&&root.right.val<=root.val){
            b= false;
        }
        if(root.left!=null&&root.left.left!=null){
            c= isValidBST(root.left);
        }
        if(root.right!=null&&root.right.right!=null){
            d= isValidBST(root.right);
        }
        return a&&b&&c&&d;

    }
}
