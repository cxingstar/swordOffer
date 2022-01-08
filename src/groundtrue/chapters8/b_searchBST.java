package groundtrue.chapters8;

public class b_searchBST {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){
            this.val = x;
        }
    }
    // 二叉搜索树
    public TreeNode searchBST(TreeNode root, int val){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val)
                break;
            if(cur.val < val){
                cur = cur.right;
            }
            else
                cur = cur.left;
        }
        return cur;
    }
}
