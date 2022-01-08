package groundtrue.chapters8;

import java.util.HashMap;
import java.util.Map;

public class o50 {


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


    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root,targetSum,map,0);

    }
    private int dfs(TreeNode root, int targetSum, Map<Integer,Integer> map, int path){
        if(root == null)
            return 0;
        path += root.val;
        int count = map.getOrDefault(path - targetSum, 0);
        map.put(path,map.getOrDefault(path,0)+1);
        count += dfs(root.left,targetSum,map,path);
        count += dfs(root.right,targetSum,map,path);
        map.put(path,map.get(path) - 1);
        return count;
    }
}
