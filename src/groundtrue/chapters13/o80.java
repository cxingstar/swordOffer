package groundtrue.chapters13;

import java.util.LinkedList;
import java.util.List;

public class o80 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        helper(res, sub, 1, k, n);
        return res;

    }
    private void helper(List<List<Integer>> res, LinkedList<Integer> sub, int index, int k, int n){

        if(k == 0){
            res.add(new LinkedList<Integer>(sub));
            return;
        }
        else if(k < 0 || index > n)
            return;
        else if(index <= n){
            helper(res,sub,index + 1, k, n);
            sub.add(index);
            helper(res,sub,index + 1, k - 1,n);
            sub.removeLast();
        }
    }
}
