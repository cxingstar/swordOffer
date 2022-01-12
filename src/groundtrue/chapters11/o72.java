package groundtrue.chapters11;

public class o72 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid <= x / mid){
                if((mid + 1) > x /(mid + 1))
                    return mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;

            }
        }
        return 0;
    }
}
