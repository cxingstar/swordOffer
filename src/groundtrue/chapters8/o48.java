package groundtrue.chapters8;

public class o48 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null)
                return "#";
            String leftStr = serialize(root.left);
            String rightStr = serialize(root.right);
            return String.valueOf(root.val) + ","+ leftStr +","+ rightStr;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            int[] i = {0};
            return dfs(nodes,i);
        }
        private TreeNode dfs(String[] nodes, int[] i){
            String str = nodes[i[0]];
            i[0]++;
            if(str.equals("#"))
                return null;
            TreeNode node = new TreeNode(Integer.valueOf(str));
            node.left = dfs(nodes,i);
            node.right = dfs(nodes,i);
            return node;
        }
    }

}
