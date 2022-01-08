package groundtrue.chapters8;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class a_preorder {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        dfs(root,res);
        return res;
    }
    private void dfs(TreeNode root,List<Integer> res){
        if(root!= null){
            res.add(root.val);
            dfs(root.left,res);
            dfs(root.right,res);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return res;
    }
}
