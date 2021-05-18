package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test28
 * @Author: Lux_er
 * @Date: 2021/3/26 0026 上午 9:10
 * @Description:
 * 实现strStr()函数。
 * 给定一个haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回-1。
 */
public class Test28 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String haystack = utils.inputStr();
        String needle = utils.inputStr();
        int index = strStr(haystack,needle);
        System.out.println(index);
    }

    private static int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();
        for(int start = 0;start < n - L + 1;++start){
            if(haystack.substring(start,start+L).equals(needle)){
                return start;
            }
        }
        return -1;
    }
}
