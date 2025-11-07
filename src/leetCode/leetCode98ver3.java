package leetCode;
/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/

//解法2,中序遍历升序,我要多看几遍,太巧妙了
public class leetCode98ver3 {
    private Long prevValue = null;
    boolean isValidBST(TreeNode root) {
        // 只需要调用我们的中序遍历辅助函数即可
        return inOrder(root);
    }

    /**
     * 这是一个“中序遍历”函数
     * - 如果遍历中发现不满足“递增”，返回 false
     * - 如果遍历完都满足，返回 true
     */
    private boolean inOrder(TreeNode root) {

        // 1. 基线条件：空节点，是有效的
        if (root == null) {
            return true;
        }

        // 2. "左" (Left)
        // 递归地检查左子树。
        // 如果左子树已经报告了 false, 我们就不用再比了,
        // 立刻停止，并把 false 传递上去。
        if (!inOrder(root.left)) {
            return false;
        }

        // 3. "根" (Root) - *** 核心检查逻辑 ***
        //    (此时，左子树已全部访问完)
        //    我们来处理“当前”节点

        // 检查： "上一个值" (prevValue) 是否存在，
        // 以及“当前值” (root.val) 是否小于等于“上一个值”。
        if (prevValue != null && root.val <= prevValue) {
            // 如果是，说明序列不是“严格递增”的，
            // 立即返回 false。
            return false;
        }

        // 如果检查通过，说明到目前为止还是“递增”的。
        // 我们更新“上一个值”为“当前值”，为下一次比较做准备。
        prevValue = (long)root.val; // (转成 long 存储)

        // 4. "右" (Right)
        // 递归地检查右子树，并返回它的结果。
        return inOrder(root.right);
    }
}
