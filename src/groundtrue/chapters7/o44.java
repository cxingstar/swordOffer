package groundtrue.chapters7;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o44 {


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

    public List<Integer> largestValues(TreeNode root) {
        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
            current = 1;
        }
        List<Integer> res = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            max = Math.max(max,node.val);
            current--;
            if(node.left != null){
                queue.offer(node.left);
                next++;
            }
            if(node.right != null){
                queue.offer(node.right);
                next++;
            }
            if(current == 0){
                res.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return res;
    }
}
