package real;

import java.util.Arrays;

public class ali_1 {
    public String reverseAndReplace(String word){
        char[] res = word.toCharArray();
//        StringBuilder stringBuilder = new StringBuilder(word);
//        stringBuilder.setCharAt(1,'i');
//        System.out.println(stringBuilder);
        reverse(res,0,word.length()-1);
        for(int i = 0; i + 3 < res.length; i++){
            if(String.valueOf(Arrays.copyOfRange(res,i,i+3)).equals("ila")){
                reverse(res,i,i+2);
            }
        }
        System.out.println(res);
        return String.valueOf(res);
    }

    public void reverse(char[] word,int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            char ch = word[j];
            word[j] = word[i];
            word[i] = ch;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ali_1 method = new ali_1();
        method.reverseAndReplace("keep aliw1 ali alia");
    }
}
