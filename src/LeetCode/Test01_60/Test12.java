package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test12
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:49
 * @Description:
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 */
public class Test12 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int num = utils.inputNumber();
        String res = intToRoman(num);
        System.out.println(res);
    }

    private static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < values.length && num > 0;i++){
            while(values[i] <= num){
                sb.append(strs[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}
