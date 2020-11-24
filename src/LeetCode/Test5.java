package LeetCode;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/11/16 - 22:48
 * @Description:
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String res = longestPalindrome(str);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len == 1){
            return s;
        }
        int count = 0;
        int temp = 0;
        String str = "";
        char[] arr = s.toCharArray();
        boolean hasPalindrome = false;
        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                if(arr[i] == arr[j]){
                    if(isPalindrome(arr,i,j)){
                        temp = j - i + 1;
                        hasPalindrome = true;
                    }
                    if(temp > count){
                        count = temp;
                        String ss = "";
                        for(int k = i;k <= j;k++){
                            ss = ss + arr[k];
                        }
                        str = ss;
                    }
                }
            }
        }
        if(!hasPalindrome){
            str = arr[0]+"";
        }
        return str;
    }

    private static boolean isPalindrome(char[] arr,int i, int j) {
        boolean flag = true;
        while(i != j){
            if(arr[i] == arr[j] && j - i == 1){
                break;
            }else if(arr[i] == arr[j]){
                i++;
                j--;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
