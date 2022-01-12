package groundtrue.chapters9;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class o60 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                (e1,e2) -> e1.getValue() - e2.getValue());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(minHeap.size() < k)
                minHeap.offer(entry);
            else if(entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        int[] res = new int[minHeap.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry: minHeap){
            res[i++] = entry.getKey();
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (e1,e2) -> e1[1] - e2[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(minHeap.size() < k)
                minHeap.offer(new int[]{entry.getKey(),entry.getValue()});
            else if(entry.getValue() > minHeap.peek()[1]){
                minHeap.poll();
                minHeap.offer(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        int[] res = new int[minHeap.size()];
        int i = 0;
        for(int[] num: minHeap){
            res[i++] = num[0];
        }
        return res;
    }

}
