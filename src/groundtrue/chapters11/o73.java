package groundtrue.chapters11;

public class o73 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = Integer.MIN_VALUE;
        for (int pile : piles)
            max = Math.max(max,pile);
        int right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int h1 = getHour(piles,mid);
            int h2 = getHour(piles,mid - 1);
            if(h1 <= h){
                if(h2 > h)
                    return mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return -1;
    }
    private int getHour(int[] piles, int speed){
        int res = 0;
        for(int pile : piles)
            res += Math.ceil((double)pile / speed);
        return res;
    }
}
