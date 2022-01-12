package groundtrue.chapters12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class o74 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals,(e1, e2) -> e1[0] - e2[0]);
        int i = 0;
        while(i < intervals.length){
            int j = i + 1;
            int[] tmp= new int[]{intervals[i][0],intervals[i][1]};
            while(j < intervals.length){
                if(tmp[1] < intervals[j][0])
                    break;
                tmp[1] = Math.max(tmp[1],intervals[j][1]);
                j++;
            }
            res.add(tmp);
            i = j;
        }
        int[][] result = new int[res.size()][];
        return res.toArray(result);
    }
}
