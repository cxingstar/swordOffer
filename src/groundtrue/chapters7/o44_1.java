package groundtrue.chapters7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o44_1 {
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
    // 双队列实现二叉树广度优先搜索
    public List<Integer> largestValues(TreeNode root){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root != null){
            queue1.offer(root);
        }
        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            max = Math.max(max,node.val);

            if(node.left != null){
                queue2.offer(node.left);
            }
            if(node.right != null){
                queue2.offer(node.right);
            }
            if(queue1.isEmpty()){
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

}
