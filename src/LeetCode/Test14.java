package LeetCode;

/**
 * @title: Test14
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:54
 * @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Test14 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = utils.inputStr();
        }
        String res = longestCommonPrefix(strings);
        System.out.println(res);
    }

    private static String longestCommonPrefix(String[] arr) {
        if(arr.length == 0 || arr == null){
            return "";
        }
        String lonStr = arr[0];
        for(int i = 1;i < arr.length;i++){
            lonStr = longestPrefixBetween(lonStr,arr[i]);
            if(lonStr.length() == 0){
                break;
            }
        }
        return lonStr;
    }

    private static String longestPrefixBetween(String str1, String str2) {
        int length = str1.length() < str2.length() ? str1.length() : str2.length();
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}
