package groundtrue.chapters3;

import java.util.HashMap;

public class o14 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a'] += 1;
            arr[s2.charAt(i) - 'a'] -= 1;
        }
        if(check(arr))
            return true;
        for(int i = s1.length(); i < s2.length(); i++){
            arr[s2.charAt(i - s1.length()) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
            if(check(arr))
                return true;
        }
        return false;



    }
    private boolean check(int[] arr){
        for(int each: arr)
            if (each != 0)
                return false;
        return true;
    }
}
