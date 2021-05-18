package LeetCode.Test01_60;
import java.util.Scanner;
/**
 * @title: Test38
 * @Author: Lux_er
 * @Date: 2021/3/11 0011 下午 5:09
 * @Description:
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * 	countAndSay(1) = "1"
 * 	countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 */
public class Test38 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String res = countAndSay(n);
        System.out.println(res);
    }

    private static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        int start = 0;
        for (int i = 1; i < len+1; i++) {
            if(i == len){
                sb.append(i-start).append(str.charAt(start));
            }else if(str.charAt(i) != str.charAt(start)){
                sb.append(i-start).append(str.charAt(start));
                start = i;
            }
        }
        return sb.toString();
    }
}
