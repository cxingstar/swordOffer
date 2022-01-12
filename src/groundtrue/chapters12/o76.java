package groundtrue.chapters12;

import java.util.PriorityQueue;

public class o76 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums){
            if(queue.size() >= k){
                if (queue.peek() < num){
                    queue.poll();
                    queue.add(num);
                }
            }else{
                queue.add(num);
            }
        }
        return queue.peek();
    }
}
