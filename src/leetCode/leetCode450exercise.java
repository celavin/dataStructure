package leetCode;

public class leetCode450exercise {
    public static void main(String[] args) {

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }else {
            //分三种情况
            if(root.left==null&&root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            else {
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right,successor.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
