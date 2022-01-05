package groundtrue.chapters6;

import java.util.Stack;

public class o36 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            switch(token){
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = calculate(num2,num1,token);
                    stack.push(res);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();

    }
    private int calculate(int num1,int num2, String token){
        switch(token){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }}
