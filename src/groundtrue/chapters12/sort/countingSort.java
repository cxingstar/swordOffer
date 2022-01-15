package groundtrue.chapters12.sort;

public class countingSort {
    public int[] countingSort(int[] nums){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int num :nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int[] counts = new int[max - min + 1];
        for(int num : nums)
            counts[num - min]++;
        int i = 0;
        for(int num = min; num <= max; num++){
            if(counts[num - min] > 0){
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
    }
}
