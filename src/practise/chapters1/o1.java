package practise.chapters1;

public class o1 {
// 整数除法
    public int divide(int dividend, int divisor){
        if(dividend == 0x80000000 && divisor == -1)
            return Integer.MAX_VALUE;
        int negative = 2;
        if(dividend > 0){
            negative -= 1;
            dividend = -dividend;
        }
        if (divisor > 0){
            negative -= 1;
            divisor = -divisor;
        }
        int result = divideCore(dividend,divisor);
        return negative == 1 ? -result : result;
    }
    private int divideCore(int dividend, int divisor){
        int result = 0;
        while (dividend <= divisor){
            int que = 1;
            int value = divisor;
            while(divisor >= 0xc0000000 && dividend <= value + value){
                value += value;
                que += que;
            }
            result += que;
            dividend -= value;
        }
        return result ;


    }

    public static void main(String args[]){
        o1 method = new o1();
        int result = method.divide(100,2);
        System.out.println(result);
    }
}
