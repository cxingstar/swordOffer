package groundtrue.chapters12;

public class o75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for(int each : arr1){
            counts[each]++;
        }
        int[] res = new int[arr1.length];
        int i = 0;
        for(int each : arr2){
            while(counts[each] > 0){
                counts[each]--;
                res[i++] = each;
            }
        }
        for(int num = 0; num < counts.length; num++){
            while(counts[num] > 0){
                res[i++] = num;
                counts[num]--;
            }

        }
        return res;
    }
}
