package groundtrue.chapters2;

import java.util.HashMap;

public class o10 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            sum += num;
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            if(map.containsKey(sum))
                map.put(sum,map.get(sum)+1);
            else
                map.put(sum,1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }

}
