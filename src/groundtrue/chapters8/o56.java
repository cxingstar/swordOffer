package groundtrue.chapters8;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class o56 {

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


    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(set.contains(k - cur.val))
                return true;
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }






    public class BSTIteratorReversed{
        TreeNode cur;
        Stack<TreeNode> stack;
        public BSTIteratorReversed(TreeNode root){
            cur = root;
            stack = new Stack<>();
        }
        public boolean hasPrev(){
            return cur != null || !stack.isEmpty();
        }
        public int prev(){
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.right;
                }
                cur = stack.pop();
                int prev = cur.val;
                cur = cur.left;
                return prev;
            }
            return -1;
        }
    }

    public class BSTIterator{
        TreeNode cur;
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root){
            cur = root;
            stack  = new Stack<>();
        }
        public boolean hasNext(){
            return cur != null || !stack.isEmpty();
        }
        public int next(){
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                int next = cur.val;
                cur = cur.right;
                return next;
            }
            return -1;
        }
    }

    public boolean findTarget1(TreeNode root, int k) {
        BSTIterator nextOperator = new BSTIterator(root);
        BSTIteratorReversed prevOperator = new BSTIteratorReversed(root);
        int next = nextOperator.next();
        int prev = prevOperator.prev();
        while(next != prev){
            if(next + prev == k)
                return true;
            else if(next + prev > k)
                prev = prevOperator.prev();
            else
                next = nextOperator.next();
        }
        return false;
    }
    }
