package groundtrue.chapters1;

// 二进制加法
public class o2 {
// 个人想法
    public String addBinary(String a,String b){
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = Math.max(i,j);
        int carry = 0;
        while (k >= 0){
            int digitA = i >= 0? a.charAt(i--) -'0': 0;
            int digitB = j >= 0? b.charAt(j--) -'0': 0;
            int sum = digitA + digitB + carry;
            carry = sum / 2;
            result.append(sum % 2);
            k--;
        }
        if (carry >= 1)
            result.append(1);
        return result.reverse().toString();
    }

    // 书上原解
    public String addBinary2(String a,String b){
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0){
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        if(carry == 1)
            result.append(1);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        o2 method = new o2();
        String result = method.addBinary2("101000000","101");
        System.out.println(result);
    }
}
