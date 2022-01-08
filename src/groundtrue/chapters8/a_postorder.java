package groundtrue.chapters8;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class a_postorder {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root,List<Integer> res){
        dfs(root.left,res);
        dfs(root.right,res);
        res.add(root.val);
    }
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null ||!stack.isEmpty()){
            while(cur.left != null){
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right != null && cur.right != prev)
                cur = cur.left;
            else{
                stack.pop();
                res.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return res;
    }

    private static void postOrder(TreeNode root) {
        Stack<TreeNode> src = new Stack<TreeNode>();
        Stack<TreeNode> res = new Stack<TreeNode>();
        src.push(root);
        while(!src.isEmpty()){
            TreeNode p = src.pop();
            res.push(p);
            if(p.left != null){
                src.push(p.left);
            }
            if(p.right != null){
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while(!res.isEmpty()){
            System.out.print(res.pop().val + " ");
        }
    }

}
