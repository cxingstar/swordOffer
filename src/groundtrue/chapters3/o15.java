package groundtrue.chapters3;

import java.util.LinkedList;
import java.util.List;

public class o15 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(p.length() > s.length())
            return res;
        int[] arr = new int[26];
        for(int i = 0 ; i < p.length(); i++){
            arr[p.charAt(i) - 'a']++;
            arr[s.charAt(i) - 'a']--;
        }
        if (check(arr))
            res.add(0);
        for(int i = p.length(); i < s.length(); i++){
            arr[s.charAt(i - p.length()) - 'a']++;
            arr[s.charAt(i) - 'a']--;
            if(check(arr))
                res.add(i - p.length() + 1);
        }
        return res;


    }
    private boolean check(int[] nums){
        for(int each : nums)
            if (each != 0)
                return false;
        return true;
    }
}
