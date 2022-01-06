package groundtrue.chapters7;

import java.util.LinkedList;
import java.util.Queue;

public class o45 {
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int bottomleft = 0;
        if(root != null){
            queue1.offer(root);
            bottomleft = root.val;
        }
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(node.left != null)
                queue2.offer(node.left);
            if(node.right != null)
                queue2.offer(node.right);
            if (queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if(!queue1.isEmpty())
                    bottomleft = queue1.peek().val;
            }
        }
        return bottomleft;
    }
}
