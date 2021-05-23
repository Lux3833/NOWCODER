package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test13
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:52
 * @Description:
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。
 * 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，
 * 数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Test13 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String str = utils.inputStr();
        int res = romanToInt(str);
        System.out.println(res);
    }

    private static int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int res = 0;
        for(int i = 0;i < s.length();i++){
            res += getValue(s.charAt(i));
        }
        return res;
    }
    private static int getValue(char charAt) {
        switch (charAt){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}
