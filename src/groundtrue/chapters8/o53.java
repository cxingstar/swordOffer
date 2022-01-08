package groundtrue.chapters8;

import java.util.Stack;

public class o53 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(found){
                break;
            }else if(p == cur){
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }


    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode result = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > p.val){
                result = cur;
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return result;
    }

}
