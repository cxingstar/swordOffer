package groundtrue.chapters8;

import groundtrue.chapters4.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class a_inorder {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> nodes = new LinkedList<>();
        dfs(root,nodes);
        return nodes;
    }
    private void dfs(TreeNode root, List<Integer> nodes){
        if(root != null){
            dfs(root.left,nodes);
            nodes.add(root.val);
            dfs(root.right,nodes);

        }
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
