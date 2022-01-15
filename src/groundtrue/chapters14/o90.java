package groundtrue.chapters14;

public class o90 {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums,1,nums.length - 1));
    }
    private int helper(int[] nums, int start, int end){
        if(start > end)
            return 0;
        else if(start == end)
            return nums[start];
        else{
            int[] dp = new int[end - start + 2];
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start],nums[start + 1]);
            for(int i = start + 2; i <= end; i++){
                dp[i - start] = Math.max(dp[i - start - 2] + nums[i], dp[i - start - 1]);
            }
            return dp[end - start];
        }
    }
}
