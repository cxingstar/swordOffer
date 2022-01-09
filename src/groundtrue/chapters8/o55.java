package groundtrue.chapters8;

import java.util.Stack;

public class o55 {

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

    class BSTIterator {
        TreeNode cur;
        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            this.cur = root;
        }

        public int next() {
            while(cur!= null || !stack.isEmpty()){
                while(cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                int res = cur.val;
                cur = cur.right;
                return res;
            }
            return -1;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
