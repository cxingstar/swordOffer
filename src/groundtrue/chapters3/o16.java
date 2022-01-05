package groundtrue.chapters3;

// 双指针
public class o16 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int right = 0;
        int left = 0;
        int[] counts = new int[256];
        while(right < s.length()){
            counts[s.charAt(right)]++;
            if(check(counts))
                res = Math.max(res,right - left + 1);
            else{
                while(left <= right){
                    counts[s.charAt(left++)]--;
                    if(check(counts))
                        break;
                }
            }
            right++;
        }
        return res;
    }
    private boolean check(int[] nums){
        for(int each: nums)
            if (each > 1)
                return false;
        return true;
    }
}
