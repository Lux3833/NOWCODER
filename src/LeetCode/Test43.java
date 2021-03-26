package LeetCode;
/**
 * @title: Test43
 * @Author: Lux_er
 * @Date: 2021/3/20 0020 下午 2:23
 * @Description:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Test43 {
    public static void main(String args[]){
        Utils utils = new Utils();
        String str1 = utils.inputNumber()+"";
        String str2 = utils.inputNumber()+"";
        String res = multiply(str1.trim(),str2.trim());
        System.out.println(res);
    }

    private static String multiply(String str1, String str2) {
        if("0".equals(str1) || "0".equals(str2)){
            return "0";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        int[] val = new int[len1+len2];
        for (int i = len1-1;i >= 0;i--) {
            for (int j = len2-1;j >= 0;j--) {
                int index = len1-1-i+len2-1-j;//对比竖式乘法，同一列下多个积相加
                val[index] += (ch1[i] -'0')*(ch2[j] - '0');//非常重要
            }
        }
        for (int i = 0; i < val.length-1; i++) {
            val[i+1] += val[i] / 10;
            val[i] = val[i] % 10;
        }
        int index = val.length-1;
        while (val[index] == 0){
            index--;
        }
        StringBuilder sb = new StringBuilder();
        while (index >= 0){
            sb.append(val[index--]);
        }
        return sb.toString();
    }
}
