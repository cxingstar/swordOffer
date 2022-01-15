package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o83 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int index){
        if(index > nums.length)
            return;
        LinkedList<Integer> sub = new LinkedList<>();
        if(index == nums.length){
            for(int each : nums)
                sub.add(each);
            res.add(sub);
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            helper(res, nums, index + 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
