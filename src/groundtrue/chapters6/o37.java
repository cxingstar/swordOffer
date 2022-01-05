package groundtrue.chapters6;

import java.util.Stack;

public class o37 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int as : asteroids){
            while(!stack.empty() && stack.peek() > 0 && stack.peek() < -as)
                stack.pop();
            if(!stack.empty() && as < 0 && stack.peek() == - as )
                stack.pop();
            else if(as > 0 || stack.empty() || stack.peek() < 0)
                stack.push(as);
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.empty()){
            res[i] = stack.pop();
            i--;
        }
        return res;
    }
}
