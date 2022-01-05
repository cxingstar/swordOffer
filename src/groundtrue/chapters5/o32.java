package groundtrue.chapters5;

import java.util.HashMap;
import java.util.Map;

public class o32 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> counts = new HashMap<>();
        if(s.length()!= t.length() || s.equals(t))
            return false;
        for(char ch: s.toCharArray())
            counts.put(ch,counts.getOrDefault(ch,0) + 1);
        for(char ch: t.toCharArray()){
            if(!counts.containsKey(ch) || counts.get(ch) == 0)
                return false;
            counts.put(ch,counts.get(ch)-1);
        }
        return true;
    }
}
