package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o81 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        helper(candidates, res, sub, target, 0 ,0);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, LinkedList<Integer> sub, int target, int index, int sum){
        if(sum == target)
            res.add(new LinkedList<Integer>(sub));
        else if(sum > target || index >= candidates.length)
            return;
        else{
            helper(candidates, res, sub, target, index + 1, sum);
            sub.add(candidates[index]);
            helper(candidates,res,sub,target,index, sum + candidates[index]);
            sub.removeLast();
        }
    }
}
