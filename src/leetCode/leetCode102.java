package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*给你二叉树的根节点 root ，
返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。*/
public class leetCode102 {
    public static void main(String[] args) {

    }
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                result.get(result.size()-1).add(current.val);
            }
        }
        return result;

    }
}
