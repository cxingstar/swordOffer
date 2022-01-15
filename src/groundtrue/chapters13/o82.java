package groundtrue.chapters13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class o82 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        helper(candidates, res, sub, target, 0 , 0);
        return res;

    }
    private void helper(int[] candidates, List<List<Integer>> res, LinkedList<Integer> sub, int target, int sum, int index){
        if(sum == target)
            res.add(new LinkedList<Integer>(sub));
        else if(index >= candidates.length || sum > target)
            return;
        else{
            helper(candidates, res, sub, target, sum, getNext(candidates,index));
            sub.add(candidates[index]);
            helper(candidates, res, sub, target, sum + candidates[index], index + 1);
            sub.removeLast();
        }
    }

    private int getNext(int[] nums, int index){
        int next = index;
        while(next < nums.length && nums[index] == nums[next])
            next++;
        return next;
    }
}
