package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o86 {
    class Solution {
        public String[][] partition(String s) {
            List<List<String>> res = new LinkedList<>();
            LinkedList<String> sub = new LinkedList<>();
            helper(res, sub, s, 0);
            String[][] convert = new String[res.size()][];
            for(int i = 0; i < res.size(); i++){
                List<String> list = res.get(i);
                String[] tmp = new String[list.size()];
                for(int j = 0; j < list.size(); j++)
                    tmp[j] = list.get(j);
                convert[i] = tmp;
            }
            return convert;
        }
        private void helper(List<List<String>> res, LinkedList<String> sub, String str,int index){
            if(index == str.length()){
                res.add(new LinkedList<String>(sub));
                return;
            }
            else if(index > str.length())
                return;
            else{
                for(int i = index; i < str.length() ; i++){
                    if(check(str,index,i)){
                        sub.add(str.substring(index, i + 1));
                        helper(res, sub, str, i + 1);
                        sub.removeLast();
                    }
                }
            }
        }
        private boolean check(String str, int start, int end){
            while(start < end){
                if(str.charAt(start++) != str.charAt(end--))
                    return false;
            }
            return true;
        }
    }
}
