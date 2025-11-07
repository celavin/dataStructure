package leetCode;
/*给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：
首先找到需要删除的节点；
如果找到了，删除它。*/

//guigui太难了,脑袋要炸了
public class leetCode450 {
    public static void main(String[] args) {

    }
    public TreeNode deleteNode(TreeNode root, int key) {

        // 1. “查找”阶段
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key); // "连接"
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // "连接"

            // 2. “删除”阶段 (key == root.val)
        } else {

            // Case 1: 叶子节点
            if (root.left == null && root.right == null) {
                return null; // “汇报” null
            }

            // Case 2: 只有一个孩子
            if (root.left == null) {
                return root.right; // “汇报”右孩子
            } else if (root.right == null) {
                return root.left; // “汇报”左孩子
            }

            // Case 3: 有两个孩子
            else {
                // --- Case 3: 我 (root) 有两个孩子 ---

                // 1. 找到“继任者”：
                //    即“我右子树中最小的那个节点”。
                //    (我们知道，它一定在右子树的“最左边”)
                TreeNode successor = findMin(root.right);

                // 2. “移花接木”：
                //    我“偷”走“继任者”的值(val)，
                //    用它的“灵魂”覆盖我自己的“灵魂”。
                root.val = successor.val;

                // 3. “清理现场”：
                //    现在，树上有两个“继任者”的值了（一个在 root，一个在 successor）。
                //    我必须把我“右部门”的那个“原始的”继任者删掉。
                //
                //    “继任者”既然是“最小的”，它一定没有“左孩子”。
                //    所以删除它，100% 只是一个 Case 1 或 Case 2 的简单问题。
                //    我们“递归地”命令“右部门”去删除那个值。
                root.right = deleteNode(root.right, successor.val);
            }
        }

        // 3. “常规汇报”：(把“我”自己汇报给上级，保持连接)
        return root;
    }

    /**
     * 辅助函数：找到一棵树中最小的节点 (一路向左)
     */
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
