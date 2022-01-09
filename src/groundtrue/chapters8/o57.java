package groundtrue.chapters8;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class o57 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            Long lower = set.floor((long)nums[i]);
            if(lower != null && lower >= (long)nums[i] - t)
                return true;
            Long upper = set.ceiling((long)nums[i]);
            if(upper != null && upper <= (long)nums[i] + t)
                return true;
            set.add((long)nums[i]);
            if(i >= k)
                set.remove((long)nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }

}
