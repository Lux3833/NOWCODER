package Other.Zuo.Base.ForceRecursion;

import java.util.Stack;

/**
 * @title: ReverseStackUsingRecursive
 * @Author: Lux_er
 * @Date: 2021/4/25 0025 上午 9:11
 * @Description:
 */
public class ReverseStackUsingRecursive {
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
