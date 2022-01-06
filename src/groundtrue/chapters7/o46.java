package groundtrue.chapters7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o46 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root != null)
            queue1.offer(root);
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(node.left != null)
                queue2.offer(node.left);
            if(node.right != null)
                queue2.offer(node.right);
            if(queue1.isEmpty()){
                res.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
