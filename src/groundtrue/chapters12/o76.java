package groundtrue.chapters12;

import groundtrue.chapters12.sort.quickSort;

import java.lang.reflect.Array;
import java.util.Arrays;
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

    public int findKthLargest1(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = getMiddle(nums, start, end);
        while(index != target){
            System.out.println(Arrays.toString(nums));
            System.out.println(index);
            if(target > index)
                index = getMiddle(nums, index + 1, end);
            else
                index = getMiddle(nums, start, index - 1);
        }
        return nums[index];
    }

    public void quickSort(int[] nums, int low, int high){
        if(low < high){
            int index = getMiddle(nums,low,high);
            System.out.println(index);
            quickSort(nums,low,index - 1);
            quickSort(nums,index +1, high);
        }
    }

    public int getMiddle(int[] nums, int low, int high){
        int tmp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= tmp) high--;
            System.out.println(nums[low]+ " "+ nums[high]);
            nums[low] = nums[high];
            while(low < high && nums[low] <= tmp) low++;
            System.out.println(nums[low]+ " "+ nums[high]);
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        o76 method = new o76();
        int[] nums = new int[]{1,12,231,34,123,34,45};
        method.quickSort(nums,0,nums.length -1);
        System.out.println(Arrays.toString(nums));
    }

}
