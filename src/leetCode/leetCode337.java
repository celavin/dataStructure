package leetCode;
/*小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。*/

//好难啊我不行了
public class leetCode337 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        int[] result = findMax(root);
        return Math.max(result[0],result[1]);
    }

    private int[] findMax(TreeNode root) {
        if(root==null){
            return new int[]{0,0};
        }
        int[] left_value = findMax(root.left);
        int[] right_value = findMax(root.right);

        return new int[]{Math.max(left_value[1],left_value[0])+Math.max(right_value[0],right_value[1]),
                left_value[0]+right_value[0]+root.val};

    }
}
