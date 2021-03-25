package LeetCode;

import java.util.Stack;

/**
 * @title: Test20
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:22
 * @Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，
 * 判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Test20 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String s = utils.inputStr();
        boolean res = isValid(s);
        System.out.println(res);
    }

    private static boolean isValid(String str) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack1.push(str.charAt(i));
        }
        Stack<Character> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
            char temp = stack1.pop();
            if(stack2.isEmpty()){
                stack2.push(temp);
            }else if(match(stack2,temp)){
                stack2.pop();
            }else{
                stack2.push(temp);
            }
        }
        if(stack2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private static boolean match(Stack<Character> stack2, char temp) {
        char ch = stack2.peek();
        boolean res = false;
        switch (ch){
            case '(':
            case '[':
            case '{':
                break;
            case ')':
                if(temp == '('){
                    res = true;
                }
                break;
            case ']':
                if(temp == '['){
                    res = true;
                }
                break;
            case '}':
                if(temp == '{'){
                    res = true;
                }
                break;
        }
        return res;
    }
}
