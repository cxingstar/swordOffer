package groundtrue.chapters5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class o35 {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints); // 集合排序
        //Arrays.sort(arr); 数组排序
        int[] arr = new int[timePoints.size()+1];
        int i = 0;
        for(String str : timePoints){
            String[] split = str.split(":");
            int time = Integer.parseInt(split[0])* 60 + Integer.parseInt(split[1]);
            arr[i] = time;
            i++;
        }
        arr[timePoints.size()] = arr[0] + 1440;

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < arr.length - 1; j++)
            res = Math.min(res,arr[j+1] - arr[j]);
        return res;
    }


    public int findMinDifference1(List<String> timePoints) {
        boolean[] arr = new boolean[1440];
        if(timePoints.size() > 1440)
            return 0;
        for(String str : timePoints){
            String[] split = str.split(":");
            int time = Integer.parseInt(split[0])* 60 + Integer.parseInt(split[1]);
            if (arr[time])
                return 0;
            arr[time] = true;
        }
        int prev = -1;
        int res = Integer.MAX_VALUE;
        int last = -1;
        int first =1439;
        for(int i = 0; i < 1440; i++ ){
            if(arr[i]){
                if(prev >= 0)
                    res = Math.min(res,i - prev);
                prev = i;
                last = Math.max(last,i);
                first = Math.min(first,i);
            }
        }
        return Math.min(res , 1440 +  first - last );
    }
}
