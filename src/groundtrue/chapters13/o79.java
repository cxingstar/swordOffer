package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o79 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        if(nums.length == 0)
            return res;
        helper(nums,res, sub, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> result, LinkedList<Integer> sub, int index){
        if(index == nums.length)
            result.add(new LinkedList<>(sub));
        else if(index < nums.length){
            helper(nums, result, sub, index + 1);
            sub.add(nums[index]);
            helper(nums, result, sub, index + 1);
            sub.removeLast();
        }
    }
}
