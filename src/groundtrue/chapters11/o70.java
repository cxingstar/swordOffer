package groundtrue.chapters11;

public class o70 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, n = nums.length, r = n/2-1;
        while(l<=r) {
            int mid = l+((r-l)>>1);
            if(nums[mid*2]!=nums[mid*2+1]) {
                // 数对中两数不等，缩小右边界，往左查找
                r = mid - 1;
            } else {
                // 数对中两数相等，缩小左边界，往右查找
                l = mid + 1;
            }
        }
        return nums[l*2];
    }
}
