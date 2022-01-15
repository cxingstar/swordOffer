package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o85 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res, "", 0 , 0, n);
        return res;
    }
    private void helper(List<String> res, String cur, int left, int right,int n){
        if(left < right || left > n || right > n)
            return;
        else if(left == n && right == n)
            res.add(cur);
        else{
            helper(res, cur + "(", left + 1, right, n);
            helper(res, cur + ")", left, right + 1, n);
        }
    }
}
