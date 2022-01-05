package groundtrue.chapters2;

import java.util.HashMap;

public class o6 {
// 双指针
    public int[] twoSum(int[] numbers,int target){
        int i = 0;
        int j = numbers.length - 1;
        while(i < j && numbers[i] + numbers[j] != target)
            if(numbers[i] + numbers[j] > target)
                j--;
            else
                i++;
        return new int[]{i,j};
    }
 // 二分查找+顺序扫描
    public int[] twoSum2(int[] numbers,int target){
        int num = numbers.length;
        for(int i = 0; i < num; i++){
            int left = i+1;
            int right = num-1;
            int subTarget = target - numbers[i];
            while(left <= right){
                int mid = (left + right) / 2;
                if (numbers[mid] == subTarget)
                    return new int[]{i,mid};
                else if (numbers[mid] > subTarget)
                    right = mid - 1;
                else
                    left  =  mid + 1;
            }
        }
        return new int[]{0,0};
    }
// 扫描+哈希
public int[] twoSum3(int[] numbers,int target){
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0;i < numbers.length;i++){
        if (map.containsKey(numbers[i]))
            return new int[]{map.get(numbers[i]),i};
        map.put(target - numbers[i],i);
    }
    return new int[]{0,0};
}
}
