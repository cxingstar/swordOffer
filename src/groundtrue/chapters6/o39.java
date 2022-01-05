package groundtrue.chapters6;

import java.util.Stack;

public class o39 {

    public int largestRectangleArea(int[] heights) {
        return helper(heights,0,heights.length);
    }
    private int helper(int[] heights, int start, int end){
        if (start == end)
            return 0;
        if(start + 1 ==  end)
            return heights[start];
        int minIndex = start;
        for (int i = start+1;i < end; i++)
            if(heights[i] < heights[minIndex])
                minIndex = i;
        int area = (end - start) * heights[minIndex];
        int left = helper(heights,start, minIndex);
        int right = helper(heights,minIndex + 1 ,end);
        area = Math.max(area,left);
        return Math.max(area,right);
    }

    // 单调栈 左边找到第一个比当前高小的数，右边从栈顶是第一个找到当前高小的数 相乘得到以当前高为高的最大矩形
    // 栈内保持递增，当前栈还未空，还需要出栈所有节点，计算最大矩形
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(h * w, maxArea);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea,h * w );
        }
        return maxArea;
    }
}
