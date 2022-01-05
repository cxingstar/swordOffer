package groundtrue.chapters6;

import java.util.Stack;

public class o40 {
    public int maximalRectangle(String[] matrix) {
        if(matrix.length == 0 || matrix[0].length() == 0)
            return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length()];
        for(String str: matrix){
            for(int i = 0 ; i < str.length();i++){
                if(str.charAt(i) == '0')
                    heights[i] = 0;
                else
                    heights[i]++;
            }
            res = Math.max(maxArea(heights),res);
        }
        return res;
    }

    private int maxArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea,h * w);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea,h * w);
        }
        return maxArea;
    }
}
