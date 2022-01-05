package groundtrue.chapters2;

public class o12 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int total = 0;
        for(int num: nums)
            total += num;
        for(int i = 0 ;i < nums.length; i++){
            sum += nums[i];
            if (sum - nums[i] == total - sum)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        o12 method = new o12();
        int result = method.pivotIndex(new int[]{2,1,-1});
        System.out.println(result);
    }
}
