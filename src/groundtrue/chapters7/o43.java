package groundtrue.chapters7;

import java.util.LinkedList;
import java.util.Queue;

public class o43 {
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
    class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> queue;
        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            queue.offer(root);
            while(queue.peek().left != null && queue.peek().right != null){
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode node =new TreeNode(v);
            TreeNode parent = queue.peek();
            if(parent.left == null)
                parent.left = node;
            else{
                parent.right = node;
                queue.poll();
                queue.offer(parent.left);
                queue.offer(parent.right);
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
