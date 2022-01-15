package groundtrue.chapters13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class o84 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, 0 , nums);
        return res;
    }

    private void helper(List<List<Integer>> res, int index, int[] nums){
        if(index == nums.length){
            LinkedList<Integer> sub = new LinkedList<>();
            for(int each : nums)
                sub.add(each);
            res.add(sub);
        }
        else if(index > nums.length)
            return;
        else{
            Set<Integer> set = new HashSet<>();
            for(int i = index; i < nums.length; i++){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    swap(nums, index, i);
                    helper(res, index + 1, nums);
                    swap(nums, index, i);
                }
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
