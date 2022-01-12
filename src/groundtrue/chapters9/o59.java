package groundtrue.chapters9;

import java.util.Collections;
import java.util.PriorityQueue;

public class o59 {
    //构造小顶堆：
    //PriorityQueue small=new PriorityQueue<>();
    //
    //构造大顶堆：
    //PriorityQueue small=new PriorityQueue<>(Collections.reverseOrder());

    //PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
    //                (e1,e2) -> e1.getValue() - e2.getValue()); 小根堆

    //PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
    //                (e1,e2) -> e2.getValue() - e1.getValue()); 大根堆

    //PriorityQueue<int[]> minHeap = new PriorityQueue<>(
    //                (e1,e2) -> e2.getValue() - e1.getValue()); 大根堆

//    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
//        public int compare(int[] m, int[] n) {
//            return m[1] - n[1];
//        }
//    });
    class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int size;
        public KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>();
            for(int num : nums)
                add(num);
        }

        public int add(int val) {
            if(minHeap.size() < size)
                minHeap.offer(val);
            else if(val > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }


}
