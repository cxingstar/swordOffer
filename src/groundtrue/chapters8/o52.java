package groundtrue.chapters8;

import java.util.Stack;

public class o52 {
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

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        // first 表示第一个访问的节点
        // prev 表示上一次被访问的节点
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev != null){
                prev.right = cur;
            }else{
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }
}
