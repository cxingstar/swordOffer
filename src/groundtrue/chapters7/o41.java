package groundtrue.chapters7;

import java.util.LinkedList;
import java.util.Queue;

public class o41 {
    class MovingAverage {
        private int size;
        private int sum;
        private Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if(queue.size() > size)
                sum -= queue.poll();
            return (double)sum / queue.size();

        }
    }
}
