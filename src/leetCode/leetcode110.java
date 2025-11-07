package leetCode;
/*给定一个二叉树，判断它是否是 平衡二叉树  */
/*一棵高度平衡二叉树是指树中的任意（every）节点，其左、右子树的深度（高度）差的绝对值不超过 1。*/

//这道题我得好好学习一下
public class leetcode110 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        // 只要 checkDepth 返回的不是 -1，就说明是平衡的
        return checkDepth(root) != -1;
    }

    /**
     * 一个“后序遍历”函数
     * - 如果 root 平衡, 返回它的高度
     * - 如果 root 不平衡, 返回 -1
     */
    private int checkDepth(TreeNode root) {
        // 1. 基线条件
        if (root == null) {
            return 0;
        }

        // 2. 左
        int leftHeight = checkDepth(root.left);
        // 剪枝：如果左子树已经报告-1，没必要再算了，直接返回-1
        if (leftHeight == -1) {
            return -1;
        }

        // 3. 右
        int rightHeight = checkDepth(root.right);
        // 剪枝：如果右子树已经报告-1，直接返回-1
        if (rightHeight == -1) {
            return -1;
        }

        // 4. 根
        // 检查我这一层是否平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 不平衡, 报告 -1
        } else {
            // 平衡, 报告我的真实深度
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
