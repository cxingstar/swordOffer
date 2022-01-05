package groundtrue.chapters2;

public class o9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int count = 0;
        int res = 1;
        while(right < nums.length){
            res *= nums[right];
            while(left <= right && res >= k)
                res /= nums[left++];
            count += left <= right ? right - left +1 :0;
            right += 1;
        }
        return count;

    }
}
