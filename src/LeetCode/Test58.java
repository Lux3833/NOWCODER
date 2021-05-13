package LeetCode;

import java.util.Scanner;

/**
 * @title: Test58
 * @Author: Lux_er
 * @Date: 2021/5/13 0013 下午 3:13
 * @Description:最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class Test58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(lengthOfLastWord(str));
    }
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 || s == " "){
            return 0;
        }
        String[] strings = s.split(" ");
        for (int i = strings.length-1;i >= 0;i--) {
            if(isWord(strings[i])){
                return strings[i].length();
            }
        }
        return 0;
    }

    private static boolean isWord(String string) {
        char[] chs = string.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(!(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z')){
                return false;
            }
        }
        return true;
    }
}
