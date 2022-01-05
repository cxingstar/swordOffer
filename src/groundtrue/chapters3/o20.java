package groundtrue.chapters3;

public class o20 {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += countPalindrome(s,i,i);
            count += countPalindrome(s,i,i+1);

        }
        return count;
    }

    private int countPalindrome(String s, int start,int end){
        int count = 0;
        for(;start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end);start--, end++, count++);
        return count;
    }

    private int countPalindrome1(String s, int start,int end){
        int count = 0;
        for(;start >= 0 && end < s.length() ;start--, end++){
            if(s.charAt(start) == s.charAt(end))
                count++;
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        o20 method = new o20();
        int result = method.countSubstrings("fdsklf");
        int cnt = method.countPalindrome("fdsklf",2,3);
        System.out.println(cnt);
        System.out.println(result);
    }
}
