package groundtrue.chapters1;

public class o4 {

// 只出现一次的数字
    public int singleNumber(int[] nums) {
        int[] bitsNum = new int[32];
        for(int num:nums){
            for (int i = 0;i < 32;i++){
                bitsNum[i] += (num >> (31-i))&1;
        }
        }

        int result = 0;
        for(int i:bitsNum)
            result = (result << 1) + i % 3;
        return result;

    }

}
