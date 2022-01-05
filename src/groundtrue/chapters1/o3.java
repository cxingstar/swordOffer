package groundtrue.chapters1;

import java.util.ArrayList;
import java.util.Arrays;

public class o3 {

    // 前n个数字二进制形式中的1的个数
    // i & (i - 1) 等价于 将i最右边的1变成0 11000 & 10111 -> 10000

    public int[] countBits1(int num){
        int[] result = new int[num+1];
        for(int i = 0; i <= num; i++){
            int j = i;
            while(j != 0){
                result[i]++;
                j = j & (j-1);
            }
        }
        return result;
    }
    // 整数 i & (i-1) 比 i多1个1
    public int[] countBits2(int num){
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++)
            result[i] = result[i&(i-1)] + 1;
        return result;
    }


    // i/2的计算结果 偶数的话比i/2相同 奇数的话比i/2多一个1
    public int[] countBits3(int num){
        int[] result = new int[num+1];
        for(int i = 1; i <= num; i++)
            result[i] = result[i >> 2] + (i & 1);
        return result;

    }

    public static void main(String[] args) {
        o3 method = new o3();
        int[] result = method.countBits1(4);
        for(int x:result)
            System.out.println(x);
        for(int i = 0 ;i < result.length;i++)
            System.out.println(result[i]);
        System.out.println(result.toString());
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.deepToString(new int[][]{result}));
    }
}
