package groundtrue.chapters9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class o61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2)->p2[0] + p2[1] - p1[0] - p1[1]);
        for(int i = 0 ; i < Math.min(k,nums1.length); i++)
            for(int j = 0; j < Math.min(k,nums2.length); j++){
                int[] root = maxHeap.peek();
                if(maxHeap.size() < k)
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                else if(nums1[i] + nums2[j] < root[0] + root[1]){
                    maxHeap.poll();
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                }
            }
        List<List<Integer>> res = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            int[] each = maxHeap.poll();
            res.add(Arrays.asList(each[0],each[1]));
        }
        return res;
    }
}
