package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test8
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:38
 * @Description:
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class Test8 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String str = utils.inputStr();
        int res = myAtoi(str);
        System.out.println(res);
    }

    private static int myAtoi(String str) {
        int zheng = 1;
        int index=0;
        long value=0;
        while (index<str.length()&&str.charAt(index)==' ') {//防止"" 和 "   "等
            index++;
        }
        if(index>str.length()-1)return 0;
        if(str.charAt(index)=='+') {index++;}
        else if (str.charAt(index)=='-') {
            zheng=-1;index++;
        }

        for(int j=index;j<str.length();j++)
        {
            if(str.charAt(j)>='0'&&str.charAt(j)<='9')
            {
                value=value*10+str.charAt(j)-'0';
                if(value*zheng>Integer.MAX_VALUE)return Integer.MAX_VALUE;
                if(value*zheng<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            }
            else {
                break;
            }
        }
        value=zheng*value;
        return (int)value;
    }
}
