package groundtrue.chapters2;

public class o8 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            int tmp = 0;
            for(int j = i; j < nums.length && j - i + 1 < result; j++){
                tmp += nums[j];
                if(tmp >= target)
                    result = Math.min(result,j - i +1);
            }
        }
        return result == Integer.MAX_VALUE ?  0 : result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0;right < nums.length;right++){
            sum += nums[right];
            while(left <= right && sum >= target){
                result = Math.min(result,right - left +1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ?  0 : result;
    }
}
