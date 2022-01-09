package groundtrue.chapters8;

import java.util.Stack;

public class o54 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public TreeNode convertBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            int sum = 0;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.right;
                 cur = stack.pop();
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}
