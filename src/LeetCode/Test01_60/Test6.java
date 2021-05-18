package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test6
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:25
 * @Description:
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时,排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Test6 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String str = utils.inputStr();
        int numRows = utils.inputNumber();
        String res = convert(str,numRows);
        System.out.println(res);
    }

    private static String convert(String str, int numRows) {
        String res = "";
        if(numRows == 1){
            return  str;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean revert = false;//当遇到第一层或者最后一层时改变方向
        char[] words = str.toCharArray();
        for(char c : words){
            list.get(row).append(c);
            if(row == 0 || row == numRows - 1){
                revert = !revert;
            }
            row += revert ? 1 : -1;
        }
        for(StringBuilder sb : list){
            res += sb.toString();
        }
        return res;
    }
}
