package groundtrue.chapters5;

import java.lang.reflect.Array;
import java.util.*;

public class o33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            groups.putIfAbsent(key,new LinkedList<String>());
            groups.get(key).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4,1,2,3,6};
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
